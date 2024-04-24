# Project Title: An Ghealtacht

## Contributors
- Aimee Daly, Jack O’Gorman, Niamh Armour
- Student Number: C22424534, C22410324, C22397066
- Class Group: TU858-2
- GitHub: [Aimeedalyyy/OOP-assignment](https://github.com/Aimeedalyyy/OOP-assignment)


## Description of the Project

### How it Works

**Aimee:** My part of the project was making the interaction between the sketches and the music. To do this, I received both the music files and sketches from Niamh and Jack via GitHub and began working. The first part of my job was trying to understand how we could process 5 different audio files at the same time, making sure they would all run together as Jack intended. I put all 5 audio files into the `setup()` of the program and made one shared buffer between all audios. Once all 5 audio files were in and working, I began working on the `keyPressed()` function and its changing of the mode variable which is used in the `switch` statement in the `draw()` function. Once both of these functions were working, I started on the interaction between sketches and music.

- **Case 1: Line** - Each line's thickness reacts to the level of intensity for each sample in the buffer.
- **Case 2: Mandala** – The Mandala is being drawn to the beat of the music.
- **Case 3: Disco Ball** – The Disco ball graphics larger sphere spins on its X axis using frame count multiplied by rotation speed. Rotation Speed is set by mapping the amplitude to a range of 0 – 0.1, this allows a higher amplitude to allow for faster rotation.
- **Case 4: Rotating Cube** – Each small cube in the larger cube spins on its x-axis also using the ‘rotation speed’ variable.
- **Case 5: Sphere in Cube** – This graphic reacts to the levels of amplitude. With each different level, the cube goes in and out accordingly. This is controlled by the sphere size being dynamically changed with each calling of the `draw` function and the normalized amplitude changing with each call.
- **Case 6: Flower** – The colour of the flower reacts to each element in the lerpedBuffer. The lerped buffer then is mapped between 100 – 150 as I wanted each ‘petal’ to be green and these are the ranges of green in an HSB colour chart. The shade of green then changes according to the amplitude within the buffer.

**Jack:** In this project my job was to create the music and make the designs. I first started by creating music. I started by making a melody on the tin whistle and then I filled the song out by adding more instruments such as mandolin, banjo, squeeze box and guitar. I then sent all the original files to Aimee. After the I then got to work on the designs. I Started with a laser idea as if you were in a club I started by drawing the lines in random locations then proceeded to add colour. I made sure then you can interact with it by adding a mouse press to clear the lines that have been drawn and start the cycle over again. I then decided to make a flower design to represent nature as when writing this song, the inspiration was the nature of Ireland. I started by making the middle circle to use as a center point and then adding all the other circles. I used a for loop to create them in a pattern. I then added colour to them. I always made sure to push any work I have done to keep my team up to date on the work I was doing. 

**Niamh:** In this project, I was given some of the tasks to create designs for the visuals. I created four designs, the mandala type design, the sphere in a box, the disco-ball and cube. When looking through previous years I could see some interesting designs, especially with circles, cubes and sphere which I took lots of inspiration from. For the Mandala design, I had wanted to create a design that kind of resembled a Celtic knot and when I was trying to draw some ideas out, they kept on turning out like intertwining circles which I ended up using to create this design. Inside the loop, the loop calculates the coordinates of a point using trigonometric functions to create circular motion. A hollow ellipse with a random colour and a thickness of 10 pixels for its outline is drawn for each iteration. The coordinate system is rotated by 30 degrees after tracing each ellipse. As the loop progresses, the angle used for the circular motion gradually increases, as the loop progresses. This creates a dynamic visual effect where a series of rotating ellipses are drawn, radiating outwards from the center of the screen. For the Sphere in a box, I used code from a previous lab, lab 6. This code creates a visual representation where the size and colour of a sphere inside a cube change based on the music. For the Cube, I watched a YouTube video and followed along with his coding. I found his explanation and detail of coding to be extremely useful. This is the video I followed along with Cube Code (Animated Cube of Cubes with Java and Processing, Dave Briccetti, 27th August 2017). Taking inspiration from that video led me on to creating my Disco-ball design. I was able to take the basic idea and structure of what I wanted my shape to do, i.e. rotating with the music, then rather than having a box, I replaced it with a sphere instead. This would be the design I am most proud of as I was able to use my new learned knowledge from Dave’s video and with his understanding implement my own version with a different shape to get a similar effect.

## Instructions for Use

A key pressed function using a global mode variable is used throughout the assignment to change between each design. Using the numbers 1-6 in a case switch statement allows you to change the design being displayed.

## What I am Most Proud of in the Assignment

**Aimee:** I am most proud of the unique ideas we came up with as a group for this project and how we worked together through the process of finishing the assignment. The idea and execution of making our own music piece, and brainstorming designs to go along with it, was a process in which we learned how best to evenly distribute the workload, with each of our strengths in mind. Using designs given to me by Niamh and Jack and editing this code to change dynamically allowed me to further understand how to use GitHub and work as a team via GitHub, a skill I will undeniably need in the future.

**Jack:** Through this whole project I would have to be most proud of the music which I wrote for this assignment. It was a very cool experience to see my music making the designs move.

**Niamh:** I am not the most creative and the best at creating processing artwork, so I had to look up lots of videos and code to help me try to create some designs. I am most proud of creating the rotating ‘disco ball’. From following a YouTube video to create the cube. I was able to take similar elements and change the shape to represent a sphere.

## What I Learned

**Aimee:** The main thing I learned while doing this project was the detail of processing audio files to make a change in graphics. I played around with different audio buffer functions, like size and level and also learned the finer details of built-in functions like mapping and lerping. The final graphic really helped me understand these two java functions, as I lerped the buffer to have a smoother transition between elements and then mapped this buffer to be in the “green range”(100-150) on the HSB colour wheel.

**Jack:** In this project I have learned how to work with a team using GitHub. At the start I found it very difficult to use git and make sure that I have been keeping my branch up to date. In this project I have also learned how to make my creations react to a piece of music. I find this very interesting as a DJ and music engineer and will use this skill to help my art. Overall I loved doing this project and found it very useful and find it will help me in my career.

**Niamh:** Throughout this assignment, I improved my skills within the GitHub space and learned how to use the git commands for merging and changing branches. I found it interesting to learn how multiple people can work in one repository together in different branches and in the end merge everything together to unite everyone's work. I also learned how to use the translate() function which moves the origin to the center of the window and sets the initial position of the cube and using the different rotate() functions I was able to rotate the shapes.
