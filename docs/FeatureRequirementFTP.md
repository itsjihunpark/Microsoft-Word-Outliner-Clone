# Outliner App
Functional Test Plan Template  
- **Start date**: 01/20/2023  
- **Due date**: 14/04/2023
- **Main Author:** @k2115030   
- **Repository:** 
[Outliner in Personal Portfolio]


# 1 Functional tests
The below test plans are implemented in Test.java in my test package

# 2 Requirements

## 2.1  Adding a new section and requirement OR01, OR03, OR04, OR06

| **Requirement code:** | OR01, OR03, OR04, OR06  |
| ------ | ------------------------------------ | 
| **Description**      | OR01-Structured data model that is capable of storing, retrieving, OR03-Graphical interface for outliner, OR04-Appropriate OO design, OR06-adding a new section to the outline.  | 
| **Pre-condition**     | a CSV file, a working Section, Outliner, and DataAccess class|      
| **Post-condition**      | A Section Object instantiated, Added to the Outliner ArrayList<Section> section attribute which will be reflected on the Outliner_view graphical user interface  | 
| **Design notes**     | This functionality to add a new section also stores to persistent storage at the same time so the result of adding a new section should also reflect on the csv file 
| **Parameters**      | `Outliner.addSection(Section newSection)`|    
| **Step sequence**      |  |
||1. Instantiate a new Section object->`Section newSection = new Section(0,"New section Text")`|
||2. Call the Outliner Function to add new Section->`Outliner.addSection(newSection)` | 
||3. Generate new string view with this new Section Object added to the ArrayList&lt;Section&gt; section| 
||4. Use the string view generated by the Outliner when instantiating a JTextArea component on my graphical user interface  |
| **Success**      | A new Section Object is instantiated |
||1. With the correct id attribute|
||2. This Section Object is added to the ArrayList&lt;Section&gt; which is used to generate a string view|
||3. This string view is used to update the JTextArea component in my Graphical user interface|
| **Tests**      |  Testing add new Section method |
||1. Testing if a new section is instantiated and added to the Outline ArrayList&lt;Section&gt; and is reflected on the JTextArea on my Graphical interface |
||    With this method in my Tests class `Tests.testAddNewSection()` | 
||2. Test if my new Section Object was assigned a correct id attribute by its constructor| 
||   With this method `Tests.testSectionConstructorIdAllocation()` | 
| **Errors**      | Issues that was encountered |
||1. When instantiated a Section Object with the text that includes a comma, it causes my CSV parser to instantiates an incorrect Section object|
| **Alternative Flows**      | In the case a comma is included as a text attribute when user inputs|
||1. All text inputs goes through the `stringObject.replace(",", ";")` which replaces all comma's in the text input with semi colon which prevents the above issues from arising|

Table 2.1 Requirement R1

## 2.2 Adding new subSection OR10

| **Requirement code:** |  OR10      |
| ------ | ------------------------------------ | 
| **Description**      | Ability to add new subSection  | 
| **Pre-condition**     | a CSV file, a working Section, Outliner, and DataAccess class and an existing Section object that will be parenting this new section as a sub section|      
| **Post-condition**      | New section instantiated that is added to an existing section as a subSection   | 
| **Design notes**     | This functionality uses the same mechanism as adding a regular section that uses the `Outliner.addSection(new Section(int idValueOfParentSection, "New subsection text"))`. However, the first parameters must be the id of the parenting section rather than zero.  |
| **Parameters**      | `Outliner.addSection(new Section(int idValueOfParentSection, "New subsection text"))`|    
| **Step sequence**      |   |
||1. Instantiate a new Section object with the correct int subSectionOf id value->`Section newSection = new Section(int idOfParentSection,"New section Text")`|
||2. Call the Outliner Function to add new Section->`Outliner.addSection(newSection)` | 
||3. Generate new string view with this new Section Object added to the ArrayList&lt;Section&gt; section| 
||4. Use the string view generated by the Outliner when instantiating a JTextArea component on my graphical user interface  |
| **Success**      | A new Section Object is instantiated and is associated to its parenting section|
||1. With the correct id attribute|
||2. This Section Object is added to the ArrayList&lt;Section&gt; which is used to generate a string view|
||3. This string view is used to update the JTextArea component in my Graphical user interface|
| **Tests**      |  Test to see if the sub section is corrected instantiated and is correctly associated with its parenting section |
||1. Test to see if the sub section is correctly instantiated |
||   With this test method `Tests.testAddSubSection()` | 
| **Errors**      | Issues that was encountered |
||1. When instantiated a new sub Section Object with the text that includes a comma, it causes my CSV parser to instantiates an incorrect Section object|
| **Alternative Flows**      | In the case a comma is included as a text attribute when user inputs|
||1. All text inputs goes through the `stringObject.replace(",", ";")` which replaces all comma's in the text input with semi colon which prevents the above issues from arising|

Table 2.2 Requirement R2


## 2.3 Editing a section and a subsection: OR07, OR11

| **Requirement code:** | OR07, OR11      |
| ------ | ------------------------------------ | 
| **Description**      | Ability to edit an existing sections or subsection  | 
| **Pre-condition**     | Existing section Object to edit that is in the Outliner section ArrayList|      
| **Post-condition**      | Existing section object is updated with a new text   | 
| **Design notes**     | In my program, section and subsections are modeled by the same Section class. So editing a section or subsection will involve the same steps and methods used  |
| **Parameters**      | `Outliner.editSection(int id, String new text)` This method takes two parameters where the first is the id of the Section Object that is being edited and the second which is the String object which will be the updated text|    
| **Step sequence**      |   |
||1. Call to `Outliner.editSection(int id, String new text)` method|
||2. This calls a method in my utility class named DataAccess where it retrieves the section object containing the same id value as the one provided as a parameter| 
||3. uses a mutator to update the text attribute of this Section object with the provided string and updates. Subsequently, calls a method to update the CSV to the latest `DataAccess.updateCSVToLatest()` | 
||4. Now the sectionInOrder ArrayList is in order, Outliner's section ArrayList is updated and a string view is generated.  |
||5.  Using the string view generated by the Outliner the JTextArea component on my graphical user interface is updated|
| **Success**      |Section or subsection is edited with the provided string|
| **Tests**      |   |
||1. Test to see if a section or subsection that is edited is updated in the ArrayList&lt;Section&gt;section |
||   With this test method `Tests.testEditSection()` | 
| **Errors**      | Issues that was encountered |
||1. When the text to update an existing section contains a comma, it causes my CSV file to contain a section object with the wrong format which is not compatible with my CSV parser|
| **Alternative Flows**      | In the case a comma is included as a text attribute when user inputs|
||1. All text inputs goes through the `stringObject.replace(",", ";")` which replaces all comma's in the text input with semi colon which prevents the above issues from arising|

Table 2.3 Requirement R3


## 2.4 Deleting a section and a subsection: OR08, OR12

| **Requirement code:** | OR08, OR12     |
| ------ | ------------------------------------ | 
| **Description**      | Ability to delete an existing sections or subsection  | 
| **Pre-condition**     | Existing section Object to delete that is in the Outliner section ArrayList|      
| **Post-condition**      | Existing section object is deleted   | 
| **Design notes**     | Deleting a section or subsection involves deleting them from persistent storage, updating the arrayList that is used to generate a string view and finally updating GUI view|
| **Parameters**      | `Outliner.deleteSection(int id)` this method takes an integer id value of the section that will be deleted |    
| **Step sequence**      |   |
||1. Call to `Outliner.delete(int id)` method|
||2. This calls a method in my utility class named DataAccess where it removes the section object containing the same id value as the one provided as a parameter and then updates the CSV file subsequently| 
||3. Then it parses in the updated CSV file and updates the Outliner sections ArrayList which will be iterated through again to generate a new and updated string view |
||4.  Using the string view generated by the Outliner the JTextArea component on my graphical user interface is updated|
| **Success**      |Section or subsection is deleted|
| **Tests**      |   |
||1. Test to see if a section or subsection that is deleted by deleting one section out of one section and comparing the changes in size, of the Outliner's sections ArrayList |
||   With this test method `Tests.testDeleteSection()` | 
| **Errors**      |  |
||1. No errors found|
| **Alternative Flows**      | |
|||

Table 2.4 Requirement R4
