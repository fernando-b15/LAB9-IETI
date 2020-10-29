package eci.ieti;

import eci.ieti.data.CustomerRepository;
import eci.ieti.data.ProductRepository;
import eci.ieti.data.TodoRepository;
import eci.ieti.data.UsersRepository;
import eci.ieti.data.model.Customer;
import eci.ieti.data.model.Product;
import eci.ieti.data.model.Todo;
import eci.ieti.data.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootApplication
public class Application implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UsersRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

        customerRepository.deleteAll();

        customerRepository.save(new Customer("Alice", "Smith"));
        customerRepository.save(new Customer("Bob", "Marley"));
        customerRepository.save(new Customer("Jimmy", "Page"));
        customerRepository.save(new Customer("Freddy", "Mercury"));
        customerRepository.save(new Customer("Michael", "Jackson"));

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        
        customerRepository.findAll().stream().forEach(System.out::println);
        System.out.println();
        
        productRepository.deleteAll();

        productRepository.save(new Product(1L, "Samsung S8", "All new mobile phone Samsung S8"));
        productRepository.save(new Product(2L, "Samsung S8 plus", "All new mobile phone Samsung S8 plus"));
        productRepository.save(new Product(3L, "Samsung S9", "All new mobile phone Samsung S9"));
        productRepository.save(new Product(4L, "Samsung S9 plus", "All new mobile phone Samsung S9 plus"));
        productRepository.save(new Product(5L, "Samsung S10", "All new mobile phone Samsung S10"));
        productRepository.save(new Product(6L, "Samsung S10 plus", "All new mobile phone Samsung S10 plus"));
        productRepository.save(new Product(7L, "Samsung S20", "All new mobile phone Samsung S20"));
        productRepository.save(new Product(8L, "Samsung S20 plus", "All new mobile phone Samsung S20 plus"));
        productRepository.save(new Product(9L, "Samsung S20 ultra", "All new mobile phone Samsung S20 ultra"));
        
        userRepository.deleteAll();
        User user1 = new User(1L,"Fernando Barrera","fernando@mail.com");
        User user2 = new User(2L,"Luis Jaramillo","luis@mail.com");
        User user3 = new User(3L,"Carlos Castañeda","carlos@mail.com");
        User user4 = new User(4L,"Alex Prieto","alex@mail.com");
        User user5 = new User(5L,"Juan Lopez","juan@mail.com");
        User user6 = new User(6L,"Edwin Moreno","edwin@mail.com");
        User user7 = new User(7L,"Sebastian Daza","sebastian@mail.com");
        User user8 = new User(8L,"Victor Lopez","victor@mail.com");
        User user9 = new User(9L,"Yeferzon Zarate","yeferzon@mail.com");
        User user10 = new User(10L,"Rosa Barrera","rosa@mail.com");
        
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        userRepository.save(user8);
        userRepository.save(user9);
        userRepository.save(user10);
        
        todoRepository.deleteAll();
        SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
        
        todoRepository.save(new Todo(1L,"Tarea 1",1,dateFormat.parse("2020-10-1"),user1.getEmail(),"Ready"));
        todoRepository.save(new Todo(2L,"Tarea 2",5,dateFormat.parse("2020-10-2"),user2.getEmail(),"Complete"));
        todoRepository.save(new Todo(3L,"Tarea 3",3,dateFormat.parse("2020-10-3"),user3.getEmail(),"In Progress"));
        todoRepository.save(new Todo(4L,"Tarea 4",8,dateFormat.parse("2020-10-4"),user4.getEmail(),"Ready"));
        todoRepository.save(new Todo(5L,"Tarea 5",9,dateFormat.parse("2020-10-5"),user5.getEmail(),"Complete"));
        todoRepository.save(new Todo(6L,"Tarea 6",3,dateFormat.parse("2020-10-6"),user6.getEmail(),"Ready"));
        todoRepository.save(new Todo(7L,"Tarea 7",1,dateFormat.parse("2020-10-7"),user7.getEmail(),"In Progress"));
        todoRepository.save(new Todo(8L,"Tarea 8",5,dateFormat.parse("2020-10-8"),user8.getEmail(),"Ready"));
        todoRepository.save(new Todo(9L,"Tarea 9",7,dateFormat.parse("2020-10-9"),user9.getEmail(),"Complete"));
        todoRepository.save(new Todo(10L,"Tarea 10",5,dateFormat.parse("2020-11-10"),user10.getEmail(),"Ready"));
        todoRepository.save(new Todo(11L,"Tarea 11",1,dateFormat.parse("2020-11-11"),user3.getEmail(),"Complete"));
        todoRepository.save(new Todo(12L,"Tarea 12",6,dateFormat.parse("2020-11-12"),user5.getEmail(),"Ready"));
        todoRepository.save(new Todo(13L,"Tarea 13",8,dateFormat.parse("2020-11-13"),user6.getEmail(),"In Progress"));
        todoRepository.save(new Todo(14L,"Tarea 14",9,dateFormat.parse("2020-11-14"),user7.getEmail(),"Complete"));
        todoRepository.save(new Todo(15L,"Tarea 15",1,dateFormat.parse("2020-11-15"),user8.getEmail(),"In Progress"));
        todoRepository.save(new Todo(16L,"Tarea 16",3,dateFormat.parse("2020-11-16"),user9.getEmail(),"Ready"));
        todoRepository.save(new Todo(17L,"Tarea 17",4,dateFormat.parse("2020-11-17"),user7.getEmail(),"Complete"));
        todoRepository.save(new Todo(18L,"Tarea 18",2,dateFormat.parse("2020-11-18"),user10.getEmail(),"Ready"));
        todoRepository.save(new Todo(19L,"Tarea 19",3,dateFormat.parse("2020-11-19"),user9.getEmail(),"In Progress"));
        todoRepository.save(new Todo(20L,"Tarea 20",5,dateFormat.parse("2020-11-20"),user5.getEmail(),"Complete"));
        todoRepository.save(new Todo(21L,"Tarea 21",1,dateFormat.parse("2020-11-21"),user1.getEmail(),"Complete"));
        todoRepository.save(new Todo(22L,"Tarea 22",3,dateFormat.parse("2020-11-22"),user4.getEmail(),"In Progress"));
        todoRepository.save(new Todo(23L,"Tarea 23",8,dateFormat.parse("2020-11-23"),user8.getEmail(),"Complete"));
        todoRepository.save(new Todo(24L,"Tarea 24",5,dateFormat.parse("2020-11-24"),user10.getEmail(),"Complete"));
        todoRepository.save(new Todo(25L,"Tarea 25 para consulta de descripcion de mas de 30 caracteres",5,dateFormat.parse("2020-11-25"),user5.getEmail(),"Complete"));
        
        
        
        
        
        
        System.out.println("Paginated search of products by criteria:");
        System.out.println("-------------------------------");
        
        productRepository.findByDescriptionContaining("plus", PageRequest.of(0, 5)).stream().forEach(System.out::println);
        
   
        System.out.println();
        
        //Query 1
        
        Query query = new Query();
        query.addCriteria(Criteria.where("dueDate").lt(new Date()));
        List<Todo> todos = mongoOperation.find(query,Todo.class);
        System.out.println("Query 1 Total Tareas Vencidas: "+todos.size());
        for(Todo todo:todos) {
        	System.out.println("Query 1 Description: " +todo.getDescription()+" Duedate: "+todo.getDueDate());
        }	
        
        System.out.println();
        
        //Query 2
        
        Query query2 = new Query();
        query2.addCriteria(Criteria.where("Responsible").is("juan@mail.com").and("priority").gte(5));
        List<Todo> todos2 = mongoOperation.find(query2,Todo.class);
        System.out.println("Query 2 Total Tareas de Usuario juan@mail.com con Prioridad igual o superior a 5: "+todos.size());
        for(Todo todo:todos2) {
        	System.out.println("Query 2 Description: " +todo.getDescription()+" Priority: "+todo.getPriority());
        }	
        System.out.println();
        
      //Query 3
        
        for(User user:userRepository.findAll()) {
            Query query3 = new Query();
            query3.addCriteria(Criteria.where("Responsible").is(user.getEmail()));
            List<Todo> TodoForUser = mongoOperation.find(query3,Todo.class);
            if(2<=TodoForUser.size()) {
            	System.out.println("Query 3 Total de Tareas del Usuario "+user.getName()+" es de "+String.valueOf(TodoForUser.size())+" tareas");
            }
        	
        }
        System.out.println();
        
        //Query 4
        
        Query query4 = new Query();
        query4.addCriteria(Criteria.where("Description").regex(".{30,}"));
        List<Todo> todos3 = mongoOperation.find(query4,Todo.class);
        System.out.println("Query 4 Total Tareas con Descripcion de mas de 30 caracteres: "+todos3.size());
        for(Todo todo:todos3) {
        	System.out.println("Query 4 Description: " +todo.getDescription());
        }
        System.out.println();
        
        //Query 1 repository
        
        List<Todo> todos5=todoRepository.findAllByDueDateBefore(new Date());
        System.out.println("Query 1 Repository Total Tareas Vencidas: "+todos.size());
        for(Todo todo:todos5) {
        	System.out.println("Query 1 Repository Description: " +todo.getDescription()+" Duedate: "+todo.getDueDate());
        }
        
        System.out.println();
        
        //Query 2 respository
       
        List<Todo> todos6 = todoRepository.findByResponsible("juan@mail.com");
        System.out.println("Query 2 repository Total Tareas de Usuario juan@mail.com con Prioridad igual o superior a 5: "+todos6.size());
        for(Todo todo:todos6) {
        	if(5<=todo.getPriority()) {
        		System.out.println("Query 2 repository Description: " +todo.getDescription()+" Priority: "+todo.getPriority());
        	}
        }	
        System.out.println();
        
        
        //Query 3 repository
        
        for(User user:userRepository.findAll()) {
            if(2<=todoRepository.findByResponsible(user.getEmail()).size()) {
              System.out.println("Query 3 repository Total de Tareas del Usuario "+user.getName()+" es de "+String.valueOf(todoRepository.findByResponsible(user.getEmail()).size())+" tareas");
        	
        	}
        }
        
        System.out.println();
        
        //Query 4 repository

        List<Todo> todosfin = todoRepository.findAllByDescriptionMatchesRegex(".{30,}");
        System.out.println("Query 4 repository Total Tareas con Descripcion de mas de 30 caracteres: "+todosfin.size());
        for(Todo todo:todosfin) {
        	System.out.println("Query 4 repository Description: " +todo.getDescription());
        }
        System.out.println();
        
        
        
    }

}