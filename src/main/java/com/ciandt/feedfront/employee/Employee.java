package com.ciandt.feedfront.employee;

import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.excecoes.EmailInvalidoException;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Employee implements Serializable {
    private static final long serialVersionUID = -525601868125339430L;
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private String arquivo;
    static String repositorioPath = "src/main/resources/data/employee/";
    private static String arquivoCriado = "arquivo.extensao"; //TODO: alterar de acordo com a sua implementação

    public Employee(String nome, String sobrenome, String email) throws ComprimentoInvalidoException {
        this.id = UUID.randomUUID().toString();
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        arquivo = repositorioPath+id+".byte";
    }
    private static ObjectOutputStream getOutputStream(String arquivo) throws IOException {
        return new ObjectOutputStream(new FileOutputStream(arquivo));
    }

    private static ObjectInputStream getInputStream(String arquivo) throws IOException {
        return new ObjectInputStream(new FileInputStream(arquivo));
    }
    public static Employee salvarEmployee(Employee employee) throws ArquivoException, EmailInvalidoException {
        String arquivo1 = employee.getArquivo();
        try{
            List<Employee> lista = listarEmployees();
            for(Employee employee1:lista){
                if (employee.getEmail().equals(employee1.getEmail()) && !employee.getId().equals(employee1.getId())){
                    throw new EmailInvalidoException("E-mail ja cadastrado no repositorio");
                }
            }
            ObjectOutputStream oos = getOutputStream(arquivo1);
            oos.writeObject(employee);
            oos.close();
            return employee;
        } catch (IOException i) {
            throw new ArquivoException("Arquivo não encontrado");
        }
//        return null;
    }

    public static Employee buscarEmployee(String id) throws ArquivoException, EmployeeNaoEncontradoException {
        try {
            ObjectInputStream ois = null;
            ois = getInputStream(repositorioPath+id+".byte");
            Employee employee = (Employee) ois.readObject();
            ois.close();
            return employee;
        } catch (IOException | ClassNotFoundException e) {
            if(e.getClass().getSimpleName().equals("FileNotFoundException")){
                throw new EmployeeNaoEncontradoException("Employee não existe no repositório");
            }
            throw new ArquivoException("");
        }
//        return null;
    }

    public static void apagarEmployee(String id) throws ArquivoException, EmployeeNaoEncontradoException {
        buscarEmployee(id);
        new File(String.format("%s%s.byte",repositorioPath,id)).delete();
    }

    public static List<Employee> listarEmployees() throws ArquivoException {
        List<Employee> lista = new ArrayList<>();
        Stream<Path> paths = null;
        try {
            paths = Files.walk(Paths.get(repositorioPath));
            List<String> files = paths
                    .map(p -> p.getFileName().toString())
                    .filter(p -> p.endsWith(".byte"))
                    .map(p -> p.replace(".byte", ""))
                    .collect(Collectors.toList());
            for (String file:files){
                try {
                    lista.add(buscarEmployee(file));
                } catch (EmployeeNaoEncontradoException e) {
                    throw new RuntimeException("Employee nao encontrado na lista");
                }
            }
            paths.close();
        } catch (IOException e) {
            throw new ArquivoException("");
        }

        return lista;
    }

    public static Employee atualizarEmployee(Employee employee) throws ArquivoException, EmailInvalidoException, EmployeeNaoEncontradoException {
        buscarEmployee(employee.getId());
        return salvarEmployee(employee);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws ComprimentoInvalidoException {
        if(nome.length() <= 2){
            throw new ComprimentoInvalidoException("Comprimento do nome deve ser maior que 2 caracteres.");
        } else {
            this.nome = nome;
        }
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) throws ComprimentoInvalidoException {
        if(sobrenome.length() <= 2){
            throw new ComprimentoInvalidoException("Comprimento do sobrenome deve ser maior que 2 caracteres.");
        } else {
            this.sobrenome = sobrenome;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getArquivo() {
        return arquivo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getNome(), employee.getNome()) && Objects.equals(getSobrenome(), employee.getSobrenome()) && Objects.equals(getEmail(), employee.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getSobrenome(), getEmail());
    }
}
