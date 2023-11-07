package com.backend.cashflow.service;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.backend.cashflow.enums.StringLength;
import com.backend.cashflow.model.User;
import com.backend.cashflow.repository.UserRepository;
import com.backend.cashflow.util.PasswordHasher;
import com.backend.cashflow.verification.ColumnVerify;
import com.backend.cashflow.verification.EmailVerify;
import com.backend.cashflow.verification.PasswordVerify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UserRepository repository;

    @Mock
    private EmailVerify emailVerify;

    @Mock
    private ColumnVerify columnVerify;

    @Mock
    private PasswordVerify passwordVerify;

    @Mock
    private PasswordHasher passwordHasher;

    private UserService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        service = new UserService(
                repository,
                emailVerify,
                columnVerify,
                passwordHasher,
                passwordVerify
        );
    }

    @Test
    public void testFindAllUsers() {
        // Retornando uma lista de usuários
        List<User> userList = new ArrayList<>();
        userList.add(new User("John Doe", "johndoe@exemplo.com", "Pass12!"));
        userList.add(new User("Jane Smith", "janesmith@exemplo.com", "SecurePwd123!"));

        when(repository.findAll()).thenReturn(userList);

        // Chamando o serviço do teste
        List<User> result = service.getAllUsers();

        // Verificando se o método de serviço retorna os dados do mock do repositório
        assertEquals(userList, result);
    }

    @Test
    public void testFindById() {
        // Passando a informação do usuário com ID
        User user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("johndoe@exemplo.com");
        user.setPassword("Pass12!");

        when(repository.findById(user.getId())).thenReturn(Optional.of(user));

        Optional<User> getUserById = service.getUserById(1L);

        assertEquals(user, getUserById.get());
    }

    @Test
    public void testCreateUser_ValidUser() {
        User user = new User();//"John Doe", "johndoe@exemplo.com", "Pass12!"
        user.setName("John Doe");
        user.setEmail("johndoe@exemplo.com");
        user.setPassword("Pass12!");

        // Simulando o comportamento esperado do hash da senha
        when(passwordHasher.hashPassword(user.getPassword())).thenReturn("Pass12!");

        // Simulando o comportamento esperado das dependências
        when(repository.save(user)).thenReturn(user);
        when(emailVerify.isEmailValid(user.getEmail())).thenReturn(true);
        when(columnVerify.isColumnValid(user.getName(), StringLength.NAME)).thenReturn(true);
        when(columnVerify.isColumnValid(user.getPassword(), StringLength.PASSWORD)).thenReturn(true);
        when(passwordVerify.isPasswordValid(user.getPassword())).thenReturn(true);


        User createUser = service.createUser(user);

        assertEquals(user, createUser);
    }


    @Test
    public void testDeleteUser_UserExists() {
        Long userId = 1l;
        // Simulando o comportamento esperado do repository
        when(repository.existsById(userId)).thenReturn(true);

        service.deleteUser(userId);

        // Verificar se o método foi chamado
        verify(repository).deleteById(userId);
    }

    @Test
    public void testDeleteUser_UserNotExists() {
        Long userId = 1L;

        // Simulando o comportamento esperado do repository
        when(repository.existsById(userId)).thenReturn(false);

        // O método deve lançar uma exceção
        assertThrows(IllegalArgumentException.class, () -> service.deleteUser(userId));
    }

}
