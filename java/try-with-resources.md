notice this code
```
FileReader fr = new FileReader(path);
    BufferedReader br = new BufferedReader(fr);
    try {
        return br.readLine();
    } finally {
        br.close();
        fr.close();
    }
```
Is there any problem with it?
the answer is yes
if br.close() throws execption, the fr.close won't be executed and this will leads to resource leakage
## So what is the solution?
try-with-resources

### Syntax
try(potentiallyExceptionalStuff) {
	
}
catch(Exception e) {
}
finally{
}
In a try-with-resources statement, any catch or finally block is run after the resources declared have been closed.
