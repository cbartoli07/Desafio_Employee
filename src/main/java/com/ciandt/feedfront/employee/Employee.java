package com.ciandt.feedfront.employee;

import com.ciandt.feedfront.excecoes.ArquivoException;
import com.ciandt.feedfront.excecoes.ComprimentoInvalidoException;
import com.ciandt.feedfront.excecoes.EmailInvalidoException;
import com.ciandt.feedfront.excecoes.EmployeeNaoEncontradoException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;

public class Employee implements Serializable {
    private static final long serialVersionUID = -525601868125339430L;
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    static String arquivo;
    static String repositorioPath = "/home/cbartoli/Documentos/Apps/git/feedfront/src/main/resources/data/";
    private static String arquivoCriado = "arquivo.extensao"; //TODO: alterar de acordo com a sua implementação

    public Employee(String nome, String sobrenome, String email) throws ComprimentoInvalidoException {
        this.id = UUID.randomUUID().toString();
        setNome(nome);
        setSobrenome(sobrenome);
        setEmail(email);
        arquivo = repositorioPath+id+".byte";
    }

    public static Employee salvarEmployee(Employee employee) throws ArquivoException, EmailInvalidoException {
        //arrumar a excessão de email
//        arquivo = repositorioPath+employee.getId()+".byte";
//        try{
//            FileOutputStream fileOut = new FileOutputStream(arquivo);
//            ObjectOutputStream out = new ObjectOutputStream(fileOut);
//            out.writeObject(employee);
//            out.close();
//            fileOut.close();
//            return employee;
//        } catch (IOException i) {
//            throw new ArquivoException("Arquivo não encontrado");
//        }
        return null;
    }

    public static Employee buscarEmployee(String id) throws ArquivoException, EmployeeNaoEncontradoException {
//        arquivo = repositorioPath+id+".byte";
//        try {
//            FileInputStream fileOutput = new FileInputStream(arquivo);
//            ObjectInputStream ois = new ObjectInputStream(fileOutput);
//            Employee employee = (Employee) ois.readObject();
//            return employee;
//        } catch (FileNotFoundException e) {
//            throw new ArquivoException("Arquivo não encontrado");
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new EmployeeNaoEncontradoException("Employee não encontrado");
//        }
        return null;
    }

    public static void apagarEmployee(String id) throws ArquivoException, EmployeeNaoEncontradoException {
    }

    public static List<Employee> listarEmployees() throws ArquivoException {
        return null;
    }

    public static Employee atualizarEmployee(Employee employee) throws ArquivoException, EmailInvalidoException {
        return null;
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

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
