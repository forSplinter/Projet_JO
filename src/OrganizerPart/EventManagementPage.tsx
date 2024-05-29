import React, { useState, useEffect } from 'react';
import { fetchEvents, addEvent, updateEvent, deleteEvent } from './EventModel';
import styles from './CSS/Organizer.module.css';
import logo1 from '../assets/logo/logo1.png'; 
import logo2 from '../assets/logo/logo2.png';
import { Link } from 'react-router-dom';

const EventManagementPage: React.FC = () => {
    const [events, setEvents] = useState([]);
    const [newEvent, setNewEvent] = useState({ name: '', date: '', location: '' });
    const [loading, setLoading] = useState(true);
  
    useEffect(() => {
      async function loadEvents() {
        const eventsData = await fetchEvents();
        setEvents(eventsData);
        setLoading(false);
      }
      loadEvents();
    }, []);
  
    const handleCreate = async () => {
      const event = await createEvent(newEvent);
      setEvents([...events, event]);
      setNewEvent({ name: '', date: '', location: '' });
    };
  
    return (
      <div className={styles.container}>
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '50px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '50px' }} />
        </header>
        <Link to="/" className={styles.backButton}>Back to home page</Link>
        <h1>Event Management</h1>
        <div>
          <input type="text" placeholder="Event Name" value={newEvent.name} onChange={(e) => setNewEvent({ ...newEvent, name: e.target.value })} className={styles.input} />
          <input type="text" placeholder="Date" value={newEvent.date} onChange={(e) => setNewEvent({ ...newEvent, date: e.target.value })} className={styles.input} />
          <input type="text" placeholder="Location" value={newEvent.location} onChange={(e) => setNewEvent({ ...newEvent, location: e.target.value })} className={styles.input} />
          <button onClick={handleCreate} className={styles.button}>Create Event</button>
        </div>
        {events.map((event) => (
          <div key={event.id}>
            <span>{event.name} - {event.date} at {event.location}</span>
            <button onClick={() => updateEvent(event.id, newEvent)} className={styles.button}>Update</button>
            <button onClick={() => deleteEvent(event.id)} className={styles.button}>Delete</button>
          </div>
        ))}
      </div>
    );
  };
  
  export default EventManagementPage;
