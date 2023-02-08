# objectfactory classes being overriden by wsdl com.yupzipa.wsdl2java
I needed to use 2 wsdls to generate java classes to use it
the two wsdls 're ErpObjectDFFUpdateService & ErpObjectAttachmentService
the problem is the ErpObjectAttachmentService classes override the ErpObjectDFFUpdateService classes includings the ObjectFactory Classes

### My Gradle and java versions
```
gradle version : 7.6
java version : 11

```
### Here's what my gradle was: 
```
plugins {
	id 'com.yupzip.wsdl2java' version '3.0.0'
}
dependencies {
    wsdl2java("com.sun.xml.bind:jaxb-impl:2.3.3")
}
wsdl2java {
    wsdlDir = file("$projectDir/src/main/resources/wsdl")

    wsdlsToGenerate = [
            ['-autoNameResolution', "$projectDir/src/main/resources/wsdl/ErpObjectDFFUpdateService.wsdl"],
            ['-autoNameResolution', "$projectDir/src/main/resources/wsdl/ErpObjectAttachmentService.wsdl"]
    ]
    cxfVersion = "3.5.5"
    cxfPluginVersion = "3.5.5"
}
```
i just mentioned the related details

### How i solve it:
by adding ** stabilizeAndMergeObjectFactory = true **
as ** If multiple WSDLs target the same package, merge their ObjectFactory classes.** 

### How my gradle now looks like:
```
wsdl2java {
    wsdlDir = file("$projectDir/src/main/resources/wsdl")
    stabilizeAndMergeObjectFactory = true

    wsdlsToGenerate = [
            ['-autoNameResolution', "$projectDir/src/main/resources/wsdl/ErpObjectDFFUpdateService.wsdl"],
            ['-autoNameResolution', "$projectDir/src/main/resources/wsdl/ErpObjectAttachmentService.wsdl"]
    ]
    cxfVersion = "3.5.5"
    cxfPluginVersion = "3.5.5"
}
```
