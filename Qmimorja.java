import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Qmimorja {
    private LocalTime oraHyrje;

    public Qmimorja(String oraHyrje) {
        DateTimeFormatter formatiOres = DateTimeFormatter.ofPattern("HH:mm");
        this.oraHyrje = LocalTime.parse(oraHyrje, formatiOres);
    }

    public double llogaritQmimin(String oraDalje) {
        LocalTime oraDaljeDt = LocalTime.parse(oraDalje);
        long diferencaOre = this.oraHyrje.until(oraDaljeDt, ChronoUnit.HOURS);
        double qmimiTotal = diferencaOre * 1.5; // Vendosni qmimin për orë këtu
        return qmimiTotal;
    }
}