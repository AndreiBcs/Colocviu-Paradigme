
List<Judete> citesteJudete(String filename){

    List<Judete> judete = new ArrayList<>();

    File myObj = new File(filename);

    try (Scanner myReader = new Scanner(myObj))
    {
        while (myReader.hasNextLine())
        {
            String citeste = myReader.nextLine();
            String[] elem = citeste.split(" ");

            String ISO = elem[0];
            String nume = elem[1];
            String regiune = elem[2];
            String nrLoc = elem[3];
            String suprafata = elem[4];

            judete.add(new Judete(nume, ISO, nrLoc, regiune, suprafata));
        }
    }
    catch (FileNotFoundException e) {
        System.out.println("A aparut o eroare la citirea din fisier:");
        e.printStackTrace();
    }

    return judete;
}


void scrieJudeteTxt(String filename, List<Judete> judete){

    File myObj = new File(filename);

    try
    {
        FileWriter myWriter = new FileWriter(filename);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine())
        {
            String data = myReader.nextLine();
            myWriter.write(data + System.lineSeparator());
        }
        myWriter.close();
    }
    catch (IOException e)
    {
        System.out.println("A aparut o eroare la scrierea in fisier:");
        e.printStackTrace();
    }

}


void main(){

    List<Judete> judete = citesteJudete("src/main/java/judete.txt");

    judete.stream().forEach(j -> System.out.println(j.toString()));
}