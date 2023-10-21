# CS321
A system that allows immigrants to request a new green card.



Setup
Clone the repository through git bash by typing "clone https://github.com/wsheng12/CS321.git" into the terminal

What each class does:

NewGreenCard creates a business object that contains the immigrant's information. It also validates the user's information and sends it along a two-step approval process. This class stores the immigrant's information in a database and validates it by pulling pre-existing information from an external database.

WorkflowTable streamlines the process for immigrants to request a new green card. It contains two queues from which a reviewer and an approver can pull from and do their specific jobs.

This project uses Test Driven Development, the tests are there to ensure that the NewGreenCard and WorkflowTable class works even if there are changes.


Finished:
Setting up the tests for the objects.

In progress:
Coding the NewGreenCard class and the WorkflowTable.


