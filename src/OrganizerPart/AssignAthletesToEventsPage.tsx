import React, { useState, useEffect } from 'react';
import { fetchEvents, fetchAthletes, assignAthleteToEvent } from './EventModel';
import styles from './CSS/Organizer.module.css';
import logo1 from '../assets/logo/logo1.png'; 
import logo2 from '../assets/logo/logo2.png';
import { Link } from 'react-router-dom';


const AssignAthletesToEventsPage: React.FC = () => {
  const [events, setEvents] = useState([]);
  const [athletes, setAthletes] = useState([]);
  const [selectedEvent, setSelectedEvent] = useState('');
  const [selectedAthletes, setSelectedAthletes] = useState([]);

  useEffect(() => {
    const loadData = async () => {
      const loadedEvents = await fetchEvents();
      const loadedAthletes = await fetchAthletes();
      setEvents(loadedEvents);
      setAthletes(loadedAthletes);
    };
    loadData();
  }, []);

  const handleAssign = async () => {
    for (const athleteId of selectedAthletes) {
      await assignAthleteToEvent(selectedEvent, athleteId);
    }
    alert('Athletes assigned to the event successfully!');
    setSelectedAthletes([]);
  };

  return (
    <div className={styles.container}>
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '50px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '50px' }} />
        </header>

      <Link to="/" className={styles.backButton}>Back to home page</Link>
      <h1>Assign Athletes to Events</h1>
      <select value={selectedEvent} onChange={(e) => setSelectedEvent(e.target.value)}>
        {events.map(event => (
          <option key={event.id} value={event.id}>{event.name}</option>
        ))}
      </select>
      <ul>
        {athletes.map(athlete => (
          <li key={athlete.id}>
            <input type="checkbox" value={athlete.id}
              onChange={(e) => {
                if (e.target.checked) {
                  setSelectedAthletes([...selectedAthletes, athlete.id]);
                } else {
                  setSelectedAthletes(selectedAthletes.filter(id => id !== athlete.id));
                }
              }} />
            {athlete.name}
          </li>
        ))}
      </ul>
      <button onClick={handleAssign}>Assign Selected Athletes</button>
    </div>
  );
};

export default AssignAthletesToEventsPage;
