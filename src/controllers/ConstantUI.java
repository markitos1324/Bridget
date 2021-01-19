package controllers;

import java.awt.Color;
import java.awt.Font;

public class ConstantUI {

	public static final String IMG_RAMP = "/imgs/ramp.png";
	public static final String IMG_STAIRS = "/imgs/stairs.png";
	public static final String IMG_BRIDGE = "/imgs/bridge.png";
	public static final String IMG_PLAY = "/imgs/Play.png";
	public static final String IMG_PAUSE = "/imgs/Pause.png";
	public static final String IMG_START = "/imgs/Start.png";
	public static final String IMG_END = "/imgs/end.png";
	public static final String IMG_UPTC = "/imgs/LogoUptc.png";
	public static final String IMG_SISTEMS = "/imgs/logoSistemas.png";
	public static final String IMG_TRACK = "/imgs/LogoVias.png";
	
	public static final String IMG_MEN_CHILD_LUGGAGE = "/imgs/ChMLg.png";
	public static final String IMG_MEN_CHILD_NOT_LUGGAGE = "/imgs/ChMNLg.png";
	public static final String IMG_MEN_YOUNG_LUGGAGE = "/imgs/YgMLg.png";
	public static final String IMG_MEN_YOUNG_NOT_LUGGAGE = "/imgs/YgMNLg.png";
	public static final String IMG_MEN_MEN_LUGGAGE = "/imgs/MnMLg.png";
	public static final String IMG_MEN_MEN_NOT_LUGGAGE = "/imgs/MnMNLg.png";
	public static final String IMG_MEN_OLD_LUGGAGE = "/imgs/OdMLg.png";
	public static final String IMG_MEN_OLD_NOT_LUGGAGE = "/imgs/OdMNLg.png";
	
	public static final String IMG_WOMEN_CHILD_LUGGAGE = "/imgs/ChWLg.png";
	public static final String IMG_WOMEN_CHILD_NOT_LUGGAGE = "/imgs/ChWNLg.png";
	public static final String IMG_WOMEN_YOUNG_LUGGAGE = "/imgs/YgWLg.png";
	public static final String IMG_WOMEN_YOUNG_NOT_LUGGAGE = "/imgs/YgWNLg.png";
	public static final String IMG_WOMEN_MEN_LUGGAGE = "/imgs/MnWLg.png";
	public static final String IMG_WOMEN_MEN_NOT_LUGGAGE = "/imgs/MnWNLg.png";
	public static final String IMG_WOMEN_OLD_LUGGAGE = "/imgs/OdWLg.png";
	public static final String IMG_WOMEN_OLD_NOT_LUGGAGE = "/imgs/OdWNLg.png";
	
	public static final String [] COLUMSDISTANCE = new String[]{"Hora", "Persona", "Sexo", "Equipaje", "V1","V2", "V3", "VT"};
	public static final String [] COLUMSVOLUMEN = new String[]{"Hora", "Persona", "Sexo", "Equipaje"};
	public static final String [] COLUMS_EXCELL = new String[]{"Hora", "Persona", "Sexo", "Equipaje", "t1","t2", "t3", "T", "V1","V2", "V3", "VT"};
	public static final String [] COLUMS_EXCELL_VOLUMEN = new String[]{"Hora", "Persona", "Sexo", "Equipaje"};
	public static final String [] COLUMS_EXCELL_DENSITY = new String[]{"Parte 1", "", "Parte 2", "", "Parte 3", ""};
	
	public static final String DEFAULT_TIME_CRONOMETER = "00 mm: 00 ss: 00ms";
	
	public static final Color COLOR_BACKGROUND = Color.decode("#EEFFFB");
	public static final Font FONT_LETTERS = new Font("Bradley Hand ITC", Font.BOLD, 16);
	public static final Font FONT_LETTERS_CRONOMETER = new Font("Bradley Hand ITC", Font.BOLD, 30);
	public static final Font FONT_LETTERS_LIST = new Font("Elephant", Font.ROMAN_BASELINE, 16);
	
	public static final String NAME_PLAY = "Play";
	public static final String NAME_PAUSE = "Pause";
	public static final String NAME_RAMP = "ramp";
	public static final String NAME_STAIRS = "stairs";
	public static final String BUTTON_ACCEPT = "Aceptar";
	public static final String TITLE_MAIN_WINDOW = "Bridget";
	
	public static final String TITLE_BUTTONS_MALE = "HOMBRES";
	public static final String TITLE_BUTTONS_FEMALE = "MUJERES";

	public static final String NAME_CHILD_LUGGAGE = "ChildLuggage";
	public static final String NAME_CHILD_NOT_LUGGAGE = "ChildNotLuggage";
	public static final String NAME_YOUNG_LUGGAGE = "YoungLuggage";
	public static final String NAME_YOUNG_NOT_LUGGAGE = "YoungNotLuggage";
	public static final String NAME_MEN_LUGGAGE = "AdultLuggage";
	public static final String NAME_MEN_NOT_LUGGAGE = "AdultNotLuggage";
	public static final String NAME_OLD_LUGGAGE = "OldLuggage";
	public static final String NAME_OLD_NOT_LUGGAGE = "OldNotLuggage";
	public static final String NAME_SEX_MEN = "Hombre";
	public static final String NAME_SEX_WOMEN = "Mujer";
	public static final String NAME_LUGGAGE = "si";
	public static final String NAME_NOT_LUGGAGE = "no";
	
	public static final String[] VECTOR_ALL_TYPES_PERSONS_NAMES = {NAME_CHILD_LUGGAGE + "-" +NAME_SEX_MEN, NAME_CHILD_LUGGAGE+ "-" +NAME_SEX_WOMEN, NAME_CHILD_NOT_LUGGAGE + "-" +NAME_SEX_MEN,NAME_CHILD_NOT_LUGGAGE+ "-" +NAME_SEX_WOMEN,
															NAME_YOUNG_LUGGAGE + "-" +NAME_SEX_MEN, NAME_YOUNG_LUGGAGE+ "-" +NAME_SEX_WOMEN, NAME_YOUNG_NOT_LUGGAGE + "-" +NAME_SEX_MEN, NAME_YOUNG_NOT_LUGGAGE+ "-" +NAME_SEX_WOMEN
															, NAME_MEN_LUGGAGE + "-" +NAME_SEX_MEN,  NAME_MEN_LUGGAGE+ "-" +NAME_SEX_WOMEN, NAME_MEN_NOT_LUGGAGE + "-" +NAME_SEX_MEN, NAME_MEN_NOT_LUGGAGE+ "-" +NAME_SEX_WOMEN ,
															NAME_OLD_LUGGAGE + "-" +NAME_SEX_MEN, NAME_OLD_LUGGAGE+ "-" +NAME_SEX_WOMEN, NAME_OLD_NOT_LUGGAGE + "-" +NAME_SEX_MEN,  NAME_OLD_NOT_LUGGAGE+ "-" +NAME_SEX_WOMEN};
	
	public static final String[] VECTOR_ALL_TYPES_PERSONS_TX_FIELDS = {"Niño con equipaje",  "NIña con equipaje",  "Niño sin equipaje", "Niña sin equipaje",
															"Hombre joven con equipaje",  "Mujer joven con equipaje", "Hombre Joven sin equipaje", "Mujer joven sin equipaje",
															"Hombre adulto con equipaje", "Mujer adulta con equipaje", "Hombre adulto sin equipaje", "Mujer adulta sin equipaje",
															"Hombre anciano con equipaje",  "Mujer Anciana con equipaje", "Hombre anciano con equipaje", "Mujer anciana sin equipaje"};
	
	public static final int WIDTH_VIDEO = 800;
	public static final int HEIGTH_VIDEO = 400;
	public static final double STEP_RATIO = 0.1;
	
	public static final String SELECT = "Buscar";
	public static final String TITLE_URL_LABEL = "Ruta del video";
	public static final String TITLE_HOUR_LABEL = "Hora";
	public static final String TITLE_MINUTE_LABEL = "Minuto";
	
	public static final String NAME_WINDOW_DISTANCE = "Distancia";
	public static final String NAME_WINDOW_SPEED = "Velocidad";
	public static final String NAME_WINDOW_VOlUMEN = "Volumen";
	public static final String NAME_WINDOW_DENSITY = "Densidad";
	public static final String NAME_lB_DISTANCE = "Distancia";
	public static final String NAME_LB_PENDING = "Pendiente";
	public static final String NAME_LB_WIDTH = "Ancho";
	public static final Object EXTENSION_VIDEO = "mp4";
	
	public static final Object MSSG_ERROR_VIDEO = "Porfavor seleccione un video.";
	public static final String MSSG_ERROR_EXTENCION_VIDEO = "Extencion invalida seleccione uno con extencion mp4";
	public static final String TITLE_VIDEO_PAUSE = "Auto pausado";
	public static final String NAME_CB_SECONDS_STOP = "stop";
	public static final String NAME_CB_SECONDS_PLAY = "play";
	public static final String SELECT_FILE = "Selecciona el archivo";
	public static final String THIRD_PART = "Third";
	public static final String SECOND_PART = "Second";
	public static final String FIRST_PART = "First";
	
	public static final String DESCRIPTION_APLICATION = "<html><body>Aplicación desarrollada para el trabajo de investigación <br>"
															+ " \"variables macroscópicas en puentes peatonales para modelos de pacacidad\" <br>"
															+ "Autor: Jonatan J. Villamarín Monroy Director_ Ing.Fredy Alberto Guío B. </html></body>";
	public static final String NEW_PERIOD = "Nuevo periodo";
}