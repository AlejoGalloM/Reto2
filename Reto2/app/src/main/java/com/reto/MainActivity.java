package com.reto;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import com.reto.adapters.ColibriAdapter;
import com.reto.adapters.ConejoAdapter;
import com.reto.adapters.FocaAdapter;
import com.reto.adapters.GatoAdapter;
import com.reto.adapters.JirafaAdapter;
import com.reto.adapters.OsoAdapter;
import com.reto.adapters.PerroAdapter;
import com.reto.adapters.ZorroAdapter;
import com.reto.entity.Animales;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listViewAnimales)
    public ListView listViewAnimales;

    @BindView(R.id.editSearch)
    public EditText editSearch;

    List<Animales> listaAnimales = new ArrayList<>();

    public int[] imgAnimal = new int[]{R.drawable.perro, R.drawable.gato, R.drawable.foca,R.drawable.jirafa, R.drawable.conejo, R.drawable.colibri, R.drawable.oso,R.drawable.fox};
    public int[] sonidoAnimal = new int[]{R.raw.perro,R.raw.gato_6,R.raw.foca , R.raw.jirafa, R.raw.rabbit, R.raw.ave, R.raw.bear, R.raw.zorro};
    public String[] animals = new String[]{"Perro", "Gato", "Foca", "Jirafa", "Conejo", "Colibri", "Oso","Zorro"};
    public String[] descripcion = new String[]
            {"Mamífero carnívoro doméstico de la familia de los cánidos que se caracteriza por tener los sentidos del olfato y el oído muy finos, por su inteligencia y por su fidelidad al ser humano, que lo ha domesticado desde tiempos prehistóricos; hay muchísimas razas, de características muy diversas.",
            "Mamífero felino de tamaño generalmente pequeño, cuerpo flexible, cabeza redonda, patas cortas, cola larga, pelo espeso y suave, largos bigotes y uñas retráctiles; es carnívoro y tiene gran agilidad, buen olfato, buen oído y excelente visión nocturna; existen muchas especies diferentes.",
            "Mamífero carnívoro adaptado a la vida acuática, de 150 a 300 cm de longitud, cuerpo fusiforme, generalmente rechoncho, y cubierto de pelo corto, con cuatro patas en forma de aletas, cola apenas desarrollada, capas de grasa bajo la piel para protegerse del frío y carente de pabellones auditivos; se alimenta de peces y moluscos, y habita en mares fríos; se adapta bien a la cautividad y es inteligente y fácilmente adiestrable; hay varias especies.",
            "Mamífero rumiante de unos 5 m de alto, pelaje amarillento repleto de manchas leonadas, cuello muy largo y esbelto, crin corta, cabeza pequeña, cuernos cortos cubiertos por la piel, hocico alargado, patas delgadas (más bajas las traseras) y cola larga; es veloz y resistente, y habita en la sabana africana, formando manadas.",
            "Mamífero de cuerpo alargado y arqueado de unos 40 cm de longitud, pelo suave y espeso, orejas largas, cola corta y patas traseras más desarrolladas que las delanteras; vive en madrigueras y se reproduce con enorme rapidez; es comestible, estimado como pieza de caza y fácilmente domesticable; hay muchas especies.",
            "Ave muy pequeña, de plumaje brillante y de colores vivos, el pico muy largo y fino, que le permite alimentarse del néctar de las flores, patas muy cortas y alas muy largas; vuela suspendiéndose en el aire, gracias a la fuerza y velocidad con que bate las alas, y es la única ave capaz de volar hacia atrás; hay muchas especies diferentes, repartidas por toda América.",
            "Mamífero plantígrado del orden de los carnívoros, de gran tamaño, cuerpo macizo, pelaje largo y abundante, cuello ancho, cabeza grande, orejas redondeadas, hocico alargado, cola pequeña, y patas cortas y gruesas con cinco dedos y fuertes garras; su andar es lento y pesado; hay varias especies.",
            "Son generalmente más pequeños que otros miembros de la familia Canidae, tales como; lobos, chacales y perros domésticos. Sus rasgos típicos incluyen un fino hocico y una espesa cola. Otras características físicas varían según su hábitat. ... A diferencia de muchos cánidos, los zorros no son usualmente animales de manada."};
    private PerroAdapter perroAdapter;
    private GatoAdapter gatoAdapter;
    private ColibriAdapter colibriAdapter;
    private ConejoAdapter conejoAdapter;
    private JirafaAdapter jirafaAdapter;
    private OsoAdapter osoAdapter;
    private FocaAdapter focaAdapter;
    private ZorroAdapter zorroAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        editSearch = (EditText) findViewById(R.id.editSearch);
        listViewAnimales = (ListView) findViewById(R.id.listViewAnimales);
        loadInfo();

        listViewAnimales.setOnItemClickListener((parent, view, position, id) -> {
            Intent dataView = new Intent(this, Animal.class);
            dataView.putExtra("img", imgAnimal[position]);
            dataView.putExtra("name", animals[position]);
            dataView.putExtra("desc", descripcion[position]);
            dataView.putExtra("sonido", sonidoAnimal[position]);
            startActivity(dataView);
        });
    }

    private void loadInfo() {
        listaAnimales.add(new Animales(R.drawable.perro,"Perro", "Mamífero carnívoro doméstico de la familia de los cánidos que se caracteriza por tener los sentidos del olfato y el oído muy finos, por su inteligencia..."));
        listaAnimales.add(new Animales(R.drawable.gato,"Gato", "Mamífero felino de tamaño generalmente pequeño, cuerpo flexible, cabeza redonda, patas cortas, cola larga, pelo espeso y suave, largos bigotes y uñas retráctiles; es carnívoro y tiene gran agilidad..."));
        listaAnimales.add(new Animales(R.drawable.foca,"Foca", "Mamífero carnívoro adaptado a la vida acuática, de 150 a 300 cm de longitud, cuerpo fusiforme, generalmente rechoncho, y cubierto de pelo corto, con cuatro..."));
        listaAnimales.add(new Animales(R.drawable.jirafa,"Jirafa", "Mamífero rumiante de unos 5 m de alto, pelaje amarillento repleto de manchas leonadas, cuello muy largo y esbelto, crin corta, cabeza pequeña, cuernos cortos cubiertos por la piel..."));
        listaAnimales.add(new Animales(R.drawable.conejo,"Conejo", "Mamífero de cuerpo alargado y arqueado de unos 40 cm de longitud, pelo suave y espeso, orejas largas, cola corta y patas traseras más desarrolladas que las delanteras..."));
        listaAnimales.add(new Animales(R.drawable.colibri,"Colibri", "Ave muy pequeña, de plumaje brillante y de colores vivos, el pico muy largo y fino, que le permite alimentarse del néctar de las flores..."));
        listaAnimales.add(new Animales(R.drawable.oso,"Oso", "Mamífero plantígrado del orden de los carnívoros, de gran tamaño, cuerpo macizo, pelaje largo y abundante, cuello ancho..."));
        listaAnimales.add(new Animales(R.drawable.fox,"Zorro","Son generalmente más pequeños que otros miembros de la familia Canidae, tales como; lobos, chacales y perros domésticos. Sus rasgos típicos incluyen un fino hocico y una espesa cola..."));

        perroAdapter = new PerroAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(perroAdapter);

        gatoAdapter = new GatoAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(gatoAdapter);

        colibriAdapter = new ColibriAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(colibriAdapter);

        focaAdapter = new FocaAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(focaAdapter);

        jirafaAdapter = new JirafaAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(jirafaAdapter);

        osoAdapter = new OsoAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(osoAdapter);

        conejoAdapter = new ConejoAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(conejoAdapter);

        zorroAdapter = new ZorroAdapter(this, listaAnimales);
        listViewAnimales.setAdapter(zorroAdapter);
    }
 }