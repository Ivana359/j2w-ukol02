package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class mainController {

    private final Random random = new Random();
    private static List<String> readAllLines() throws IOException, java.io.IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        try (InputStream inputStream = classLoader.getResourceAsStream("citaty.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            return reader
                    .lines()
                    .collect(Collectors.toList());
        }
    }

    @GetMapping("/")
    public ModelAndView citat() throws IOException, java.io.IOException {

        int randomNumber = random.nextInt(9) + 1;

       /* List<String> quoteItem = List.of("Pes není zvíře, pes je přítel.", "Psi nejsou celým našim životem, ale díky nim je náš život úplný.",
                "Když pokouše pes člověka, není to nic nového, ale když člověk pokouše psa – to už je zpráva!",
                "Chceš-li být jeden den šťasten, kup si víno a pozvi přátele. Chceš-li být dva dny šťasten, ožeň se. Chceš-li být šťasten celý život, chovej psy. Jenom ti, kdož neměli nikdy psa, nemohou pochopit, oč by byl život bez psů chudší.",
                "Člověk je psí představa o tom, jak by měl vypadat Bůh.",
                "Průměrný pes je lepší osobnost než průměrný člověk.",
                "Pokud si myslíte, že psi neumí počítat, vezměte si do kapsy tři piškoty a dejte psovi jen dva.",
                "Ten, kdo řekl, že štěstí se nedá koupit, zapomněl na štěňata.",
                "Psi žijí výhradně přítomností. Jsou přívalová vlna emocí, a každá z nich je variantou lásky.",
                "Jestliže v ráji nejsou psi, potom chci po smrti jít tam, kam odešli oni.");*/


        int nahodnyCitat = random.nextInt(readAllLines().size());

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("Citat", readAllLines().get(nahodnyCitat));
        modelAndView.addObject("pozadi", String.format("/images/obrazek-%d.jpg", randomNumber));

        return modelAndView;
    }
    }









