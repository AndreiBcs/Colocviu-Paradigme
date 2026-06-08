
List<Judete> citesteJudete(String filename){

    List<Judete> judete = new ArrayList<>();

    File myObj = new File(filename);

    try (Scanner myReader = new Scanner(myObj))
    {
        while (myReader.hasNextLine())
        {

            String ISO = myReader.next();
            String nume = myReader.next();
            String regiune = myReader.next();
            long nrLoc = myReader.nextLong();
            long suprafata = myReader.nextLong();

            judete.add(new Judete(ISO, nume, regiune, nrLoc, suprafata));
        }
    }
    catch (FileNotFoundException e) {
        System.out.println("A aparut o eroare la citirea din fisier:");
        e.printStackTrace();
    }

    return judete;
}


void scrieJudeteTxt(String filename, List<Judete> judete){

    try
    {
        FileWriter myWriter = new FileWriter(filename);

        judete.forEach(j -> {
            try {
                myWriter.write(j.toString() + System.lineSeparator() + System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        myWriter.close();
    }
    catch (IOException e)
    {
        System.out.println("A aparut o eroare la scrierea in fisier:");
        e.printStackTrace();
    }

}


void scrieJudeteConsola(List<Judete> judete){

    judete.forEach(j -> System.out.println(j.toString()));

}


Optional<Judete> cautaJudete(String filename, List<Judete> judete){

    Optional<Judete> gasite = Optional.empty();

    File myObj = new File(filename);

    try (Scanner myReader = new Scanner(myObj))
    {
        while (myReader.hasNextLine())
        {
            String cautat = myReader.nextLine();

            judete.stream().allMatch(j ->
                    Objects.equals(cautat, j.ISO.toLowerCase())
                            || Objects.equals(cautat, j.nume.toLowerCase())
                            || Objects.equals(cautat, j.regiune.toLowerCase()));
        }
    }
    catch (FileNotFoundException e) {
        System.out.println("A aparut o eroare la citirea din fisier:");
        e.printStackTrace();
    }

    return gasite;
}


List<Judete> ordoneazaDensitatePopulatie(List<Judete> judete){

    judete.forEach(j -> {
        double densitate = (double) j.nrLoc / j.suprafata;

    });

    return judete.stream().sorted(j -> j.densitate).toList();
}

void main(){

    List<Judete> judete = citesteJudete("src/main/java/judete.txt");

    scrieJudeteTxt("src/main/java/output.txt", judete);

    scrieJudeteConsola(judete);
}