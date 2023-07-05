import java.util.Scanner;

public class MetodaPageses {
    private String metodaPageses;

    public MetodaPageses() {
        pyetMetodenPageses();
    }

    private void pyetMetodenPageses() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zgjidhni metodën e pagesës (elektronike/cash): ");
        metodaPageses = scanner.nextLine();

    }

    public void konfirmoPagesen(double qmimi) {
        if (metodaPageses.equalsIgnoreCase("elektronike")) {
            pageseElektronike(qmimi);
        } else if (metodaPageses.equalsIgnoreCase("cash")) {
            pageseCash(qmimi);
        } else {
            System.out.println("Metoda e zgjedhur e pagesës nuk është valide.");
        }
    }

    private void pageseElektronike(double qmimi) {
        System.out.println("Pagesa elektronike u bë me sukses.");

    }

    private void pageseCash(double qmimi) {
        System.out.println("Pagesa cash u bë me sukses.");

    }
}

