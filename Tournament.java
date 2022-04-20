
import java.io.*;
import java.util.*;

public class Tournament {

    private final int NUMBER_OF_PLAYERS = 5;
    private String name;
    private NodeList<Player> playersList;
    private ObjectOutputStream playerOut;
    private ObjectInputStream playerIn;
    private Player[] player_array;
    private String file_name = "Tournament.dat";


    public Tournament(){
        player_array = new Player[NUMBER_OF_PLAYERS];
        playersList = new NodeList<>(null);
//        fill_mock_data();
        createNewFile();
//        writeDataFile();
        readDataFile();
        sortPlayerArray();
        updatePlayerList();
        System.out.println(playersList);


    }

    public void updatePlayerList() {
        for(Player p : player_array)
            playersList.insertAtFront(new Node<>(p));
    }

    public void sortPlayerArray() {
        for(int i = 0 ; i < player_array.length; i++)
            for (int j = 0; j < player_array.length; j++)
                if(player_array[i].getTotalScore() > player_array[j].getTotalScore()){
                    Player temp = player_array[i];
                    player_array[i] = player_array[j];
                    player_array[j] = temp;
                }
//        Collections.sort(player_array, new Comparator<Player>(){
//            public int compare(Player p1, Player p2){
//
//            }
//        });

    }

    public void fill_mock_data(){
        String[] playerNames = new String[] {"Kevin", "Amit", "John", "Yuri", "Sebastian", "Jane", "Mike", "Benjamin"};
        Random random = new Random();
        for(int i = 0; i < player_array.length; i++){
            player_array[i] = new Player(playerNames[random.nextInt(playerNames.length)], random.nextInt(5, 10));
            playersList.insertAtFront(new Node<>(player_array[i]));
        }
    }



    public void createNewFile(){
        File file = new File(file_name);

        try{
            if (file.createNewFile()) {System.out.println("File *" + file.getName() + "* has been created.");}
            else                      {System.out.println("File *" + file.getName() + "* already exist.");   }
        } catch (IOException e){
            System.out.println("IOEXCEPTION while creating the 'Tournament' dat file");
            e.printStackTrace();
        }
    }


    public void writeDataFile(){

        File f = new File(file_name);
        if(!f.exists()) {
            createNewFile();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(f);
            playerOut =new ObjectOutputStream(fileOutputStream);
            playerOut.writeObject(player_array);
        } catch(Exception e){
            System.out.println(e.toString());
        }
    }



    public void readDataFile(){

        try {
            File file = new File(file_name);
            FileInputStream fileinput = new FileInputStream(file);
            playerIn = new ObjectInputStream(fileinput);
            player_array = (Player[]) playerIn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
