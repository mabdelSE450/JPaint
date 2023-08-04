# JPaint
JPaint Application for SE450:
Paint application that supports all required functionality for the first and second check-in. For the third check-in, the application supports copying a shape, pasting the copied shape, and deleting the initial selected shape to be copied. The application also displays an outline around the selected shape, which mirrors its shape type. The paste and delete functions also support undo and redo methods. The paste's undo method removes the pasted shape, and its redo does the opposite. The delete's undo method displays the initial deleted selected shape again, while its redo removes it. The two additional design patterns for this sprint are an observer pattern and a singleton pattern. For the observer pattern, I have my ShapeList class as the subject, while my PaintCanvas class is my observer. The ShapeList class implements an IShapeListSubject interface. This interface contains the required registering of observers and notifying said observers. It can be argued that a removeObserver method should be included as well, but in my scenario it seemed unnecessary. The PaintCanvas class implements an IShapeListObserver interface. This interface contains a single update method that is overridden by the PaintCavas class in order to call on its repaint method when it is notified. For my singleton design pattern, I have my PaintCanvas class acting as my single instance. It's constructor is private, and it contains a getInstance method which returns an instantiated PaintCanvas object. In my main method, the paintCanvas object is set to PaintCanvas.getInstance() and all other classes, which require a PaintCanvas object, are passed this reference into there constructor. Classes which don't take a PaintCanvas instance in there constructor use the getInstance method in order to reference the same, single, PaintCanvas instance. All required functionality for the third check-in appears to work as intended.

GitHub Repo Link:
https://github.com/mabdelSE450/JPaint