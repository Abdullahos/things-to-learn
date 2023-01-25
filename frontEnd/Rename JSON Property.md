I had a JSON response that looks like this:
{
  name: 'sara',
  age: 23, 
  address: 'dfdfgsfgfdd'
}

And I need to send it to another endpoint that takes almost the same JSON format except the address is called home_address.
so i did the following

```
to_replaced = 'address';
required = 'home_address';
res[''+required] = res[''+to_replace];
delete res[''+to_replace];
```

so, now my new JSON looks like:
{
  name: 'sara',
  age: 23, 
  home_address: 'dfdfgsfgfdd'
}
