# Smart Home Project
Android application to control Smart Home, that receives data from a Central HTTP Server. Developed for Ambient Intelligence course.

- A house configuration, is specificated in a XML file according to DomoBus Specification. (http://www.domobus.net/)

### Modules:
- **app** - all code related to the android app; dependency on :utils
- **server** - all code related to the server; dependency on :utils and JSON-java
- **commonlib** - contains all common classes like xml parser entities and XML loader

### Libraries:
- JSON-java - https://github.com/stleary/JSON-java - to parse XML files
- ButterKnife - https://github.com/JakeWharton/butterknife - to bind views easily 
