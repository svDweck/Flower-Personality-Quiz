import java.util.*;

public class Main {

    // Method used to check if the user's input is valid.
    public static boolean checkIfValid(char x){

        // Checks to see if the user's answer is one of the valid letters.
        if((65<=x&&x<=68)||(97<=x&&x<=100)){
            return true;
        }else{
            System.out.println("Please enter a valid letter answer.");
            return false;
        }
    }

    // A method that finds the most common character in an array. Used to see which answer the user picked the most.
    public static char topAnswer(char[] answers) {

        // Creates a hashmap to keep track of the individual characters in the string
        HashMap<Character, Integer> chars = new HashMap<>();

        // The letter count to keep track of
        int count = 0;

        // The most common answer to return
        char mostcommon = ' ';

        // Checks for an empty array and returns 0 if array is empty
        if (answers.length == 0 || (answers.length == 1 && answers[0] == ' ')) {
            return 0;
        }

        // Goes through the array and counts how many of its characters occur using the hashmap
        for (int i = 0; i < answers.length; i++) {
            if (!chars.containsKey(answers[i]) && answers[i] != ' ') {
                chars.put(answers[i], 1);
            } else if (answers[i] != ' ') {
                chars.put(answers[i], chars.get(answers[i]) + 1);
            }
        }

        // Goes through the counts of the letters to see which occurs the most often
        for (HashMap.Entry<Character, Integer> i : chars.entrySet()) {
            if (i.getValue() > count) {
                count = i.getValue();
                mostcommon = i.getKey();
            }
        }

        return mostcommon;
    }

    public static void main(String[] args) {

        // The LinkedHashMap with all the quiz questions and answers.
        Map<Integer, String> quiz = new LinkedHashMap<>();

        // The array will store the user's input.
        char[] answers = new char[5];
        Scanner scanner = new Scanner(System.in);

        // This will store the user's individual answers.
        char answ;

        // Prints the intro to the quiz.
        System.out.println("Let's see which type of flower suits your personality the best!");

        // Adds the questions and answers to the LinkedHashMap.
        quiz.put(0, "Which of these colors is your favorite?\nA: Yellow    B: Green    C: Pink    D: Purple");
        quiz.put(1, "Which animal do you like the most?\nA: Dolphin    B: Cat    C: Dog    D: Dove");
        quiz.put(2, "What's your favorite thing to do on a day off?\nA: Swimming    B: Painting    C: Hiking   D: Reading");
        quiz.put(3, "What kind of music is your jam?\nA: 80's    B: Pop    C: Hip-hop    D: Classical");
        quiz.put(4, "And lastly, what would be your ideal place to go on vacation?\nA: Guam    B: Ireland    C: New York    D: Paris");


        // Prints out each question. Checks if the user's input is valid and continues printing questions if it is.
        for(int i=0; i<5; i++){
            System.out.println(quiz.get(i));
            answ = scanner.next().charAt(0);
            if(checkIfValid(answ)){
                answers[i] = answ;

            }else{
                i--;

            }
        }

        // Stores the answer that was chosen the most.
        int topAnswer = topAnswer(answers);

        // Prints out the results depending on which answer the user picked the most.
        if(topAnswer == 'A'||topAnswer=='a'){
                System.out.println("Congratulations! Your flower would be a Hibiscus, the national flower of Malaysia!");
        }else if(topAnswer == 'B'||topAnswer=='b'){
            System.out.println("Congratulations! Your flower would be a Daisy, the national flower of the Netherlands!");

        }else if(topAnswer == 'C'||topAnswer=='c') {
            System.out.println("Congratulations! Your flower would be a Sunflower, the national flower of Ukraine!");

        }else if(topAnswer == 'D'||topAnswer=='d'){
            System.out.println("Congratulations! Your flower would be a Rose, the national flower of the United States!");

        }





    }
}