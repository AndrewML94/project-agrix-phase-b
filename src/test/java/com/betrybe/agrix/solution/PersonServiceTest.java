package com.betrybe.agrix.solution;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.exception.PersonNotFoundException;
import com.betrybe.agrix.ebytr.staff.repository.PersonRepository;
import com.betrybe.agrix.ebytr.staff.security.Role;
import com.betrybe.agrix.ebytr.staff.service.PersonService;

@SpringBootTest
@ActiveProfiles("test")
public class PersonServiceTest {

  @MockBean
  PersonRepository personRepository;

  @Autowired
  PersonService personService;

  @Test
  @DisplayName("Teste para verificar se ao buscar uma pessoa com um id válido, é retornado a pessoa.")
  public void testGetByIdPersonSuccess() {

    Person mockPerson = new Person();
    mockPerson.setId(1L);
    mockPerson.setUsername("josewsl2");
    mockPerson.setPassword("123456789");
    mockPerson.setRole(Role.USER);

    Mockito.when(personRepository.findById(any())).thenReturn(Optional.of(mockPerson));

    Person person = personService.getPersonById(1L);

    assertNotNull(person);
    assertEquals(mockPerson.getId(), person.getId());
    assertEquals(mockPerson.getUsername(), person.getUsername());
    assertEquals(mockPerson.getPassword(), person.getPassword());
    assertEquals(mockPerson.getRole(), person.getRole());
  }

  @Test
  @DisplayName("Teste para verificar se ao buscar uma pessoa com um id inválido, é retornado um erro.")
  public void testGetByIdPersonFailure() {
    Person mockPerson = new Person();
    mockPerson.setId(1L);
    mockPerson.setUsername("josewsl2");
    mockPerson.setPassword("123456789");
    mockPerson.setRole(Role.USER);

    Mockito.when(personRepository.findById(any())).thenReturn(Optional.empty());

    try {
      // Chama o método do serviço com um ID inválido.
      personService.getPersonById(222L);
      // Se a exceção não for lançada, o teste deve falhar.
      fail("Deveria ter lançado uma exceção");
    } catch (PersonNotFoundException e) {
      // Verifica se a mensagem de erro está correta.
      assertEquals("Pessoa não encontrada!", e.getMessage());
    }
  }

  @Test
  @DisplayName("Teste para verificar se ao buscar uma pessoa com um username válido, é retornado a pessoa.")
  public void testGetByUsernamePersonSuccess() {

    Person mockPerson = new Person();
    mockPerson.setId(1L);
    mockPerson.setUsername("josewsl2");
    mockPerson.setPassword("123456789");
    mockPerson.setRole(Role.USER);

    Mockito.when(personRepository.findByUsername(any())).thenReturn(Optional.of(mockPerson));

    Person person = personService.getPersonByUsername("josewsl2");

    assertNotNull(person);
    assertEquals(mockPerson.getId(), person.getId());
    assertEquals(mockPerson.getUsername(), person.getUsername());
    assertEquals(mockPerson.getPassword(), person.getPassword());
    assertEquals(mockPerson.getRole(), person.getRole());
  }

  @Test
  @DisplayName("Teste para verificar se ao buscar uma pessoa com um id inválido, é retornado um erro.")
  public void testGetByUsernamePersonFailure() {
    Person mockPerson = new Person();
    mockPerson.setId(1L);
    mockPerson.setUsername("josewsl2");
    mockPerson.setPassword("123456789");
    mockPerson.setRole(Role.USER);

    Mockito.when(personRepository.findByUsername(any())).thenReturn(Optional.empty());

    try {
      // Chama o método do serviço com um ID inválido.
      personService.getPersonByUsername("mariawls2");
      // Se a exceção não for lançada, o teste deve falhar.
      fail("Deveria ter lançado uma exceção");
    } catch (PersonNotFoundException e) {
      // Verifica se a mensagem de erro está correta.
      assertEquals("Pessoa não encontrada!", e.getMessage());
    }
  }

  @Test
  @DisplayName("Teste para verificar se o cadastro de uma nova pessoa ocorre corretamente.")
  public void testCreatePerson() {
    Person mockPerson = new Person();
    mockPerson.setId(1L);
    mockPerson.setUsername("josewsl2");
    mockPerson.setPassword("123456789");
    mockPerson.setRole(Role.USER);

    Mockito.when(personRepository.save(any())).thenReturn(mockPerson);

    Person person = personService.create(mockPerson);

    assertNotNull(person);
    assertEquals(mockPerson.getId(), person.getId());
    assertEquals(mockPerson.getUsername(), person.getUsername());
    assertEquals(mockPerson.getPassword(), person.getPassword());
    assertEquals(mockPerson.getRole(), person.getRole());
  }
}
