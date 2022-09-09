# frequencies-task
task issued by Wim Technologies

Good day, I hope that you are well.

I was unable to finish my task because of a small bug with my minmax map but this readme will explain my logic.

My plan was to:
1. Read the text file into a hashmap, making the Cell ID a key and then adding the coordinates into a coordinates object (and making it the value in the hashmap).
2. Iterate through the hashmap and calculate the distance between one value in the hashmap and the rest of values in the hashmap. And keeping track of the minimum and maximum distances of each entry, along with the cell IDs associated with them, in the hashmap (these values would have been stored in a separate hashmap with the cell ID being the key).
3. I was then going to assign frequencies by generating a random number between 110 and 115. Iterate through the hashmap with the minimum and maximum values and assign frequencies to the cell IDs. The cell associated with the maximum value would have the same frequency as the current cell that we're on.   

I used IntelliJ to create my project
