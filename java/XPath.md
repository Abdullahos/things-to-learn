## sometimes we need to perfrom some actions on xml file like search for tags, remove some, edit values of some, ...

**XPath is a java library for that!**

## Notice this code :D
```
 public static void parseXML() {
        File file = getFile(STANDARD_DOC);
        try (FileInputStream fileIS = new FileInputStream(file)) {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document xmlDoc = documentBuilder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            for (String expression : expressions) {
                NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDoc, XPathConstants.NODESET);
                for (int i = nodeList.getLength() - 1; i >= 0; i--) {
                    nodeList.item(i).getParentNode().removeChild(nodeList.item(i));
                }
            }
            try (FileOutputStream outputDoc = new FileOutputStream(TAGGED_REMOVE_DOC)) {
                writeXml(xmlDoc, outputDoc);
            }
        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException |
                 TransformerException e) {
            throw new RuntimeException(e);
        }
    }
```
### AS shown, this code trying to match some experssions and remove the found nodes that matches, then save to a file

### Another example:
```
 private static void removeComments(Document xmlDoc) {
        NodeList nodeList = xmlDoc.getDocumentElement().getChildNodes();
        for (int i = nodeList.getLength() - 1; i >= 0; i--) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.COMMENT_NODE) {
                node.getParentNode().removeChild(node);
            }
        }
    }
```
### This code removes any comments it founds in the xml file
**It's important to note that we itereate in reverse order over the nodes in the nodelist of the xml**

