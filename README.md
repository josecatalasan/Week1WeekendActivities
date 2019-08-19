# Week1WeekendActivities

## Feature Activities

### Picture Activity
This activity can be reached from the main activity through a FloatingActionButton. When pressed, the application runs the phone's camera and waits for a result. After a picture is taken and sent back, the picture is displayed in an ImageView within the main activity.

### EMI Calculator
This activity is launched through the ActionBar from a menu item with the icon of the dollar sign. The activity features three TextViews that display the EMI, Total Payment, and Total Interest Payment from values determined by SeekBars.


Three SeekBars and three correspond TextViews are also in this activity. The SeekBars start at default values have thumbs that can be manipulated by the user to adjust the values. The corresponding TextViews update as the SeekBars are manipulated and the calculations for the other three TextViews at the top are updated in real time as the values change.

### Person Form
This activity was launched through the ActionBar using a menu item with a person icon. The activity contains six EditTexts, six corresponding TextViews for labels, and two Buttons. The EditTexts take in the user's first name, last name, height weight, birthday, and favorite food. One Button adds this information to an ArrayList of Person objects and clear the fields. The second Button launches another activity that shows the contents of the ArrayList.

### Person Form Results
This activity was not finished.

### WebView
This activity can be launched through the Web Browser item in the overflow menu. The activity has an EditText, a Button, and a WebView which takes up most of the screen. The EditText takes in the URL of a website and the Button tells the WebView to load the URL into view.

### Media Player
This activity can be launched through the Media Player item in the overflow menu. This activity has three Buttons to Start, Pause, and Stop a single .mp3 file with the resource file of the application. It uses a MediaPlayer object to handle the .mp3 file.
