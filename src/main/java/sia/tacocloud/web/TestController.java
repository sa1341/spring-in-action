package sia.tacocloud.web;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.grpc.AddressBookProtos.AddressBook;
import sia.tacocloud.grpc.AddressBookProtos.Person;
import sia.tacocloud.grpc.AddressBookProtos.Person.PhoneNumber;
import sia.tacocloud.grpc.AddressBookProtos.Person.PhoneType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class TestController {

    private static final String PROJ_DIR = System.getProperty("user.dir");
    private final ObjectMapper objectMapper;

    @GetMapping("/protobuf")
    public String protobuf() throws IOException {

        log.info("PROJ_DIR_PATH: ", PROJ_DIR);

        PhoneNumber myPhoneNumber = PhoneNumber.newBuilder()
                .setNumber("010-7900-7714")
                .setType(PhoneType.MOBILE)
                .build();

        Person person = Person.newBuilder()
                .setId(1)
                .setEmail("a79007714@gmail.com")
                .setName("jean")
                .setPhones(myPhoneNumber)
                .build();

        AddressBook addressBook = AddressBook.newBuilder()
                .setPeople(person)
                .build();

        long start = System.nanoTime();

        FileOutputStream fos = new FileOutputStream(PROJ_DIR + File.separator + "test.txt");
        addressBook.writeTo(fos);

        FileInputStream fis = new FileInputStream(PROJ_DIR + File.separator + "test.txt");
        AddressBook inputAddressBook = AddressBook.parseFrom(fis);
        long end = System.nanoTime();

        System.err.println("proto = " + (end-start));

        return inputAddressBook.toString();
    }

    @GetMapping("/json")
    public sia.tacocloud.domain.AddressBook json() throws JsonGenerationException, JsonMappingException, IOException {

        sia.tacocloud.domain.PhoneNumber myPhoneNumber = sia.tacocloud.domain.PhoneNumber.builder()
                .number("010-7900-7714")
                .type(sia.tacocloud.domain.PhoneType.MOBILE)
                .build();

        sia.tacocloud.domain.Person person = sia.tacocloud.domain.Person.builder()
                .id(1)
                .email("a79007714@gmail.com")
                .name("jean")
                .phones(myPhoneNumber)
                .build();

        sia.tacocloud.domain.AddressBook addressBook = sia.tacocloud.domain.AddressBook.builder()
                .person(person)
                .build();

        long start = System.nanoTime();

        objectMapper.writeValue(new File(PROJ_DIR + File.separator + "test2.txt"), addressBook);

        sia.tacocloud.domain.AddressBook inputAddressBook = objectMapper.readValue(new File(PROJ_DIR + File.separator + "test2.txt"), sia.tacocloud.domain.AddressBook.class);

        long end = System.nanoTime();
        System.err.println("json = " + (end-start));
        return inputAddressBook;
    }
}
