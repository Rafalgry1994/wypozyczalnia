package pl.sda.arp4.rental.service;

import pl.sda.arp4.rental.model.Samochod;
import pl.sda.arp4.rental.model.SkrzyniaBiegow;
import pl.sda.arp4.rental.model.StatusSamochodu;
import pl.sda.arp4.rental.model.TypNadwozia;

import javax.swing.*;
import java.awt.image.SampleModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wypozyczalnia {
    private Map<String, Samochod> pojazd = new HashMap<>();
    // możemy dodac samochod
    // Co ta funkcja powinna robić
    // - dodać samochod
    //   - jeśli dodam samochód (XYZ) to ten samochód musi być w wypożyczalni
    //   - jeśli dodam 5 samochodów (różnych) to powinno być 5 różnych samochodów w wypożyczalni
    // Czego funkcja nie powinna pozwalać
    // - dodawania pojazdu o tym samym numerze rejestracyjnym
    public void dodajSamochod(String numerRejestracyjny, SkrzyniaBiegow skrzyniaBiegow, TypNadwozia typNadwozia, StatusSamochodu statusSamochodu) {
        if (!pojazd.containsKey(numerRejestracyjny)){
            pojazd.put(numerRejestracyjny, new Samochod(numerRejestracyjny, skrzyniaBiegow, typNadwozia,statusSamochodu));
            // udało się dodać samochód
            }
        }
        public List<Samochod> zwrocListe(){
        return new ArrayList<>(pojazd.values());

        }
        public List<Samochod> zwrocListeDostepnych(){
        List<Samochod> listaDostepnych = new ArrayList<>();
        for (Samochod pojazd : pojazd.values()){
            if (pojazd.getStatus() == StatusSamochodu.DOSTEPNY) {
                listaDostepnych.add(pojazd);
            }
        }
        return listaDostepnych;
        }
        public List<Samochod> zwrocListeWynajetych() {
            List<Samochod> listaWynajetych = new ArrayList<>();
            for (Samochod pojazd : pojazd.values()) {
                if (pojazd.getStatus() == StatusSamochodu.WYNAJETY) {
                    listaWynajetych.add(pojazd);

                }
            }
            return listaWynajetych;
        }
        public void usunSamochod( final String numerRejestracyjny) {
            pojazd.get(numerRejestracyjny).setStatus(StatusSamochodu.NIEDOSTEPNY);

        }
}