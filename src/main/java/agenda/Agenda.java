package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    public HashSet<Event> mesEvents = new HashSet<Event>();

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        this.mesEvents.add(e);

    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> today = new ArrayList();
        for (Event e : mesEvents) {
            if (e.isInDay(day)) {
                today.add(e);
            }

        }
        return today;
    }
 /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public List<Event> findByTitle(String title) {
        ArrayList titre = new ArrayList();
        for (Event e : mesEvents) {
            if (e.getTitle().equals(title)) {
                titre.add(e);
            }
        }
        return titre;
    }
    
    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public boolean isFreeFor(Event e) {
        for (Event evenement : mesEvents) {
            if ((evenement.getStart().isEqual(e.getStart())
                    || evenement.getStart().isAfter(e.getStart()) && evenement.getStart().isBefore(e.getStart().plus(e.getDuration())))
                    || (evenement.getStart().plus(evenement.getDuration()).isAfter(e.getStart()) && evenement.getStart().plus(evenement.getDuration()).isBefore(e.getStart().plus(e.getDuration())))
                    || evenement.getStart().isEqual(e.getStart())
                    || evenement.getStart().plus(evenement.getDuration()).isEqual(e.getStart().plus(e.getDuration()))) {
                return false;
            }
        }

        return true;
    }
} 