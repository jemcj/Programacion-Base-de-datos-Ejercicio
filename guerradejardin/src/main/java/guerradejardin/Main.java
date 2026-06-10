package guerradejardin;

import guerradejardin.DAO.GnomoAncianoDAO;
import guerradejardin.DAO.HadaMadrinaDAO;
import guerradejardin.DAO.TopoCombateDAO;

public class Main {
    public static void main(String[] args) {

        GnomoAncianoDAO gnomo = new GnomoAncianoDAO();
        TopoCombateDAO topo = new TopoCombateDAO();
        HadaMadrinaDAO hada = new HadaMadrinaDAO();

        // Gnomo -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        System.out.println("Filtrar ------------------------------------------------------------------------------");
        System.out.println(gnomo.filtrar("edad", 100));
        System.out.println("  ");

        System.out.println("Buscar ------------------------------------------------------------------------------");
        System.out.println(gnomo.buscar("nivelCascarrabias", ">", "87"));
        System.out.println("  ");

        System.out.println("cargarTopos ------------------------------------------------------------------------------");
        System.out.println(gnomo.cargarTopos(3));
        System.out.println("  ");

        System.out.println("calcularEnergiaRefunfugnoTotal ------------------------------------------------------------------------------");
        System.out.println(gnomo.calcularEnergiaRefunfugnoTotal());
        System.out.println("  ");

        System.out.println("obtenerGnomoMasCascarrabias ------------------------------------------------------------------------------");
        System.out.println(gnomo.obtenerGnomoMasCascarrabias());
        System.out.println("  ");

        System.out.println("generarInformeGnomos ------------------------------------------------------------------------------");
        System.out.println(gnomo.generarInformeGnomos());
        System.out.println("  ");

        // Topo -------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        System.out.println("Filtrar ------------------------------------------------------------------------------");
        System.out.println(topo.filtrar("agudezaOlfativa", "Alta"));
        System.out.println("  ");

        System.out.println("Buscar ------------------------------------------------------------------------------");
        System.out.println(topo.buscar("horasSueno", "=", "7"));
        System.out.println("  ");

        System.out.println("cargarToposConTierraEnOjos ------------------------------------------------------------------------------");
        System.out.println(topo.cargarToposConTierraEnOjos(6));
        System.out.println("  ");

        System.out.println("cargarToposDescansados ------------------------------------------------------------------------------");
        System.out.println(topo.cargarToposDescansados());
        System.out.println("  ");

        System.out.println("calcularPromedioFuerzaExcavacion ------------------------------------------------------------------------------");
        System.out.println(topo.calcularPromedioFuerzaExcavacion(4));
        System.out.println("  ");

        System.out.println("cargarToposPaginando ------------------------------------------------------------------------------");
        System.out.println(topo.cargarToposPaginando(20, 3));
        System.out.println("  ");

        // Hada -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        System.out.println("Filtrar ------------------------------------------------------------------------------");
        System.out.println(hada.filtrar("polvoPurpurina", "95"));
        System.out.println("  ");

        System.out.println("Buscar ------------------------------------------------------------------------------");
        System.out.println(hada.buscar("edad", "<", "190"));
        System.out.println("  ");

        System.out.println("cargarDuendes ------------------------------------------------------------------------------");
        System.out.println(hada.cargarDuendes(1));
        System.out.println("  ");

        System.out.println("calcularPolvoPurpurinaTotal ------------------------------------------------------------------------------");
        System.out.println(hada.calcularPolvoPurpurinaTotal());
        System.out.println("  ");

        System.out.println("obtenerHadaMasVeterana ------------------------------------------------------------------------------");
        System.out.println(hada.obtenerHadaMasVeterana());
        System.out.println("  ");

        //ERROR
        //En la base de datos y el DO envergaduraAlas es un STRING hay que cambiarlo a DOUBLE
        //System.out.println("cargarHadasConAlasPequeñas ------------------------------------------------------------------------------");
        //System.out.println(hada.cargarHadasConAlasPequeñas(0));
        //System.out.println("  ");
        
    }
}