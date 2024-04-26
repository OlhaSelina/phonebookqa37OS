package utils;

import dto.ContactDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {
    @DataProvider // запускает выполнение теста столько раз сколько объектов в List
    public Iterator<Object[]> addNewContact(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"Olha", "Smith", "1234567890", "some@gmail.com", "Kiew", "friend"});
        list.add(new Object[]{"Olha1", "Smith", "1234567891", "some@gmail.com", "Kiew", "friend"});
        list.add(new Object[]{"Olha2", "Smith", "1234567892", "some@gmail.com", "Kiew", "friend"});
        return list.iterator();
    }

    @DataProvider // подключаем список csv
    public Iterator<Object[]> addContactCSVFile(){
        List<Object[]> list = new ArrayList<>();
        String line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(
                    new File("src/test/resources/contacts.csv")));
            line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                list.add(new Object[]{new ContactDTO().setName(split[0]).setLastName(split[1])
                        .setPhone(split[2]).setEmail(split[3]).setAddress(split[4])
                        .setDescription(split[5])});
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list.iterator();
    }
}
