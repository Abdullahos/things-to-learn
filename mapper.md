# Mapper
## Intro to the Jackson ObjectMapper
![jackson](https://user-images.githubusercontent.com/51336081/188126051-9ee54795-30d5-4aeb-a7fc-d447af510a5a.png)

``` 
object <- json read
write object -> json

ObjectMapper provides functionality for reading and writing JSON
```
## example:
```
public class Car {

    private String color;
    private String type;
    
    @Override
    public String toString(){
      return "color: "+color+" , type: "+type;
    }
}

ObjectMapper objectMapper = new ObjectMapper();
Car car = new Car("yellow", "renault");
objectMapper.writeValue(new File("target/car.json"), car);    //create file in that path and write car in json in it


String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
Car car = objectMapper.readValue(json, Car.class);           //convert(deserialize from json format to Car object)
System.out.println(car);

```
