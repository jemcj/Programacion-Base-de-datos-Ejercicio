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

        /**
         * 
         * Filtra los gnomos según su edad. En esre caso, se filtran los gnomos que tengan una edad mayor a 100 años.
         * 
         */
        System.out.println("Filtrar ------------------------------------------------------------------------------");
        System.out.println(gnomo.filtrar("edad", 100));
        System.out.println("  ");

        /**
         * 
         * Busca los gnomos según su nivel de Cascarrabias. En este caso, se buscan los gnomos que tengan un nivel de 
         * Cascarrabias mayor a 87.
         * 
         */
        System.out.println("Buscar ------------------------------------------------------------------------------");
        System.out.println(gnomo.buscar("nivelCascarrabias", ">", "87"));
        System.out.println("  ");

        /**
         * 
         * Carga los topos del gnomo con numero de ID 3.
         * 
         */
        System.out.println("cargarTopos ------------------------------------------------------------------------------");
        System.out.println(gnomo.cargarTopos(3));
        System.out.println("  ");

        /**
         * 
         * Calcula la energía de refunfuno total de todos los gnomos.
         * 
         */
        System.out.println("calcularEnergiaRefunfugnoTotal ------------------------------------------------------------------------------");
        System.out.println(gnomo.calcularEnergiaRefunfugnoTotal());
        System.out.println("  ");

        /**
         * 
         * Obtiene el gnomo con el nivel de Cascarrabias más alto.
         * 
         */
        System.out.println("obtenerGnomoMasCascarrabias ------------------------------------------------------------------------------");
        System.out.println(gnomo.obtenerGnomoMasCascarrabias());
        System.out.println("  ");

        /**
         * 
         * Genera un informe con la información de todos los gnomos.
         * 
         */
        System.out.println("generarInformeGnomos ------------------------------------------------------------------------------");
        System.out.println(gnomo.generarInformeGnomos());
        System.out.println("  ");

        // Topo -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /**
         * 
         * Filtra los topos según su agudeza olfativa. En este caso, se filtran los topos que tengan una agudeza olfativa alta.
         * 
         */
        System.out.println("Filtrar ------------------------------------------------------------------------------");
        System.out.println(topo.filtrar("agudezaOlfativa", "Alta"));
        System.out.println("  ");

        /**
         * 
         * Busca los topos según su número de horas de sueño. En este caso, se busca que las horas de sueño sean 7.
         * 
         */
        System.out.println("Buscar ------------------------------------------------------------------------------");
        System.out.println(topo.buscar("horasSueno", "=", "7"));
        System.out.println("  ");

        /**
         * 
         * Carga los topos que tienen tierra en los ojos, que estan asociados al gnomo con ID 6.
         * 
         */
        System.out.println("cargarToposConTierraEnOjos ------------------------------------------------------------------------------");
        System.out.println(topo.cargarToposConTierraEnOjos(6));
        System.out.println("  ");

        /**
         * 
         * Carga los topos que han descansado.
         * 
         */
        System.out.println("cargarToposDescansados ------------------------------------------------------------------------------");
        System.out.println(topo.cargarToposDescansados());
        System.out.println("  ");

        /**
         * 
         * Calcula el promedio de la fuerza de excavación de los topos.
         * 
         */
        System.out.println("calcularPromedioFuerzaExcavacion ------------------------------------------------------------------------------");
        System.out.println(topo.calcularPromedioFuerzaExcavacion(4));
        System.out.println("  ");

        /**
         * 
         * Carga los topos de forma paginada.
         * 
         */
        System.out.println("cargarToposPaginando ------------------------------------------------------------------------------");
        System.out.println(topo.cargarToposPaginando(20, 3));
        System.out.println("  ");

        // Hada -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /**
         * 
         * Filtra las hadas según su cantidad de polvo de purpurina. En este caso, se filtran las hadas que tengan una 
         * cantidad de polvo de purpurina mayor a 95.
         * 
         */
        System.out.println("Filtrar ------------------------------------------------------------------------------");
        System.out.println(hada.filtrar("polvoPurpurina", "95"));
        System.out.println("  ");

        /**
         * 
         * Busca las hadas según su edad. En este caso, se busca que la edad sea menor a 190.
         * 
         */
        System.out.println("Buscar ------------------------------------------------------------------------------");
        System.out.println(hada.buscar("edad", "<", "190"));
        System.out.println("  ");

        /**
         * 
         * Carga los duendes del hada con ID 1.
         * 
         */
        System.out.println("cargarDuendes ------------------------------------------------------------------------------");
        System.out.println(hada.cargarDuendes(1));
        System.out.println("  ");

        /**
         * 
         * Calcula el total de polvo de purpurina de todas las hadas.
         * 
         */
        System.out.println("calcularPolvoPurpurinaTotal ------------------------------------------------------------------------------");
        System.out.println(hada.calcularPolvoPurpurinaTotal());
        System.out.println("  ");

        /**
         * 
         * Obtiene la hada más veterana.
         * 
         */
        System.out.println("obtenerHadaMasVeterana ------------------------------------------------------------------------------");
        System.out.println(hada.obtenerHadaMasVeterana());
        System.out.println("  ");
        
    }
}