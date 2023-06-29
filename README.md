# FabricController
Framework written in Scala to support the data engineer to write less code on 


- design class loader to load the dynamice define class form configfile
- Design inital processor for calling source & sink 
 ```{
  "application": "local_ruuner",
  "classname": "org.scala.datapipeline.Transform",
  "source": [
    {
      "source_type": "file",
      "format": "csv",
      "path": "resource/songs_details.csv",
      "options": {"header": "true"}
    }
  ],
  "sink": [
    {
      "format": "delta",
      "path": "delta/sink/"
    }
  ]
}```
