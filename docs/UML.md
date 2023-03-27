# Title
UML Class Diagram Template
- **Start date**: 01-01-1970  
- **Due date**: 01-01-1970  
- **Main Author:** @ku63026  
- **Collaborators (optional):**  
  - @ku13043, @ku17655  
- **Repository:**
[Outliner in Personal Portfolio]() Add URL 

# 1 Sub-Heading

An example [Mermaid.js](https://mermaid.js.org/) UML Class Diagram template.  This uses Markdown Perhaps some explanatory text about the application could go here with links if required.
[Info about Markdown](https://markdown.land/)  
[Info about Class Diagrams in Mermaid.js](https://mermaid.js.org/syntax/classDiagram.html)  
 

# 2 Sub-Heading
Example Class Diagram

[This was done in the Mermaid Live Editor](https://mermaid.live/)  


```mermaid
classDiagram
    Outliner "1" o-- "0..*" Section : has a 
    Section "1" o-- "0..*" Section : has a

    class User{
      -id: int
      -fullName: String
    }

    class Outliner{
    
    }

    class Outliner{
      -section: ArrayList~Sections~
      -view: String
      -INSTANCE: Outliner
      +getInstance(): Outliner
      +main(String arg[])::void
      +getSections(): ArrayList~Sections~
      +setSections(ArrayList~Sections~): void
      +getView(): String
      +setView(String): void
      +assignUser(String user): void
      +addSection(Section newSection):void
      +deleteSection(int id):void
      +editSection(int id, String newText): void
      +createView(): void
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

```
