# Outliner UML
UML Class Diagram
- **Start date**: 01-01-2023  
- **Due date**: 01-04-2023  
- **Main Author:** @k2115030
- **Repository: Outliner**
[Outliner in Personal Portfolio]() Add URL 

# 1 Class diagram

```mermaid
classDiagram
    Outliner "1" o-- "0..*" Section : has a 
    Section "1" o-- "0..*" Section : has a


    class Outliner{
      -ArrayList~Sections~ section$ 
      -String view$
      -Outliner INSTANCE$
      +getInstance()$ Outliner
      +main(String arg[])$:void
      +getSections() ArrayList~Sections~
      +setSections(ArrayList~Sections~) void
      +getView()$ String
      +setView(String)$ void
      +assignUser(String user)$ void
      +addSection(Section newSection)$void
      +deleteSection(int id)$void
      +editSection(int id, String newText)$ void
      +createView()$ void
    }
    class Section{
      -user:String
      -id:Integer
      -subSectionOf:Integer
      -text:String
      -level:Integer
      -subSection:ArrayList~Sections~
      +Section(int id, int subSectionOf, String text, int level, String user):void
      +Section():void
      +Section(int subSectionOf, String text):void
      +addSubSection(Section s)
      +toString():String
      +getId(): Integer
      +setId(Integer id): void
      +getSubSectionOf(): Integer
      +setSubSectionOf(Integer subSectionOf): void
      +getText(): String
      +setText(String text): void
      +getSubSections(): ArrayList~Sections~
      +setSubSection(ArrayList~Sections~): void
      +getUser(): String
      +setUser(String user): void
      +getLevel(): Integer
      +setLevel(Integer level):void

    }
