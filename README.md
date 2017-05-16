# Smart Home Project
Android application to control Smart Home, that receives data from a Central HTTP Server. Developed for Ambient Intelligence course.

- A house configuration, is specificated in a XML file according to DomoBus Specification. (http://www.domobus.net/)

### Modules:
- **app** - all code related to the android app; dependency on :commonLib
- **server** - all code related to the server; dependency on :commonLib
- **commonlib** - contains all common classes like XML parser entities and XML loader

### Libraries:
- ButterKnife - https://github.com/JakeWharton/butterknife - to bind views easily 
- Retrofit - https://github.com/square/retrofit - to call web requests
- GSON - https://github.com/google/gson -  to convert Java Objects into their JSON representation and vice-versa
