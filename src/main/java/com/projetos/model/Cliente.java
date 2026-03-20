package com.projetos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

/**
 * Entidade que representa um Cliente no sistema.
 *
 * Mapeada para a tabela "clientes" no banco de dados.
 * Utiliza JPA/Hibernate para persistencia e Bean Validation para validacao.
 */
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome e obrigatorio")
    @Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank(message = "O email e obrigatorio")
    @Email(message = "O email deve ser valido")
    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @NotBlank(message = "O telefone e obrigatorio")
    @Size(min = 8, max = 20, message = "O telefone deve ter entre 8 e 20 caracteres")
    @Column(nullable = false, length = 20)
    private String telefone;

    @Size(max = 14, message = "O CPF deve ter no maximo 14 caracteres")
    @Column(length = 14, unique = true)
    private String cpf;

    @Size(max = 255, message = "O endereco deve ter no maximo 255 caracteres")
    @Column(length = 255)
    private String endereco;

    // ========== CONSTRUTORES ==========

    /**
     * Construtor padrao (exigido pelo JPA/Hibernate).
     */
    public Cliente() {
    }

    /**
     * Construtor com campos obrigatorios.
     *
     * @param nome     nome do cliente
     * @param email    email do cliente
     * @param telefone telefone do cliente
     */
    public Cliente(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    /**
     * Construtor completo (todos os campos).
     *
     * @param id       identificador unico
     * @param nome     nome do cliente
     * @param email    email do cliente
     * @param telefone telefone do cliente
     * @param cpf      CPF do cliente
     * @param endereco endereco do cliente
     */
    public Cliente(Long id, String nome, String email, String telefone, String cpf, String endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // ========== GETTERS E SETTERS ==========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // ========== hashCode, equals e toString ==========

    @Override
    public int hashCode() {
        return Objects.hash(id, email, cpf);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cliente cliente = (Cliente) obj;
        return Objects.equals(id, cliente.id)
                && Objects.equals(email, cliente.email)
                && Objects.equals(cpf, cliente.cpf);
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "id=" + id
                + ", nome='" + nome + '\''
                + ", email='" + email + '\''
                + ", telefone='" + telefone + '\''
                + ", cpf='" + cpf + '\''
                + ", endereco='" + endereco + '\''
                + '}';
    }
}
