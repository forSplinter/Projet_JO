import React from 'react';
import { Link } from 'react-router-dom';
import styles from '../CSS/Organizer.module.css'; 
import logo1 from '../../assets/logo/logo1.png'; //Retour en arrière
import logo2 from '../../assets/logo/logo2.png';

const HomeOrganizer: React.FC = () => {
  return (
    <div className={styles.container}>
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '70px',padding:'10px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '90px',padding:'10px' }} />
        </header>

      <h2>Welcome to the Olympic Games Management System !</h2>

      <div className={styles.menu}>
        <Link to="/manage-athletes" className={styles.menuItem}>Manage Athletes</Link>
        <Link to="/manage-disciplines" className={styles.menuItem}>Manage Disciplines</Link>
        <Link to="/manage-events" className={styles.menuItem}>Manage Events</Link>
        <Link to="/assign-athletes" className={styles.menuItem}>Assign Athletes to Disciplines</Link>
        <Link to="/assign-athletes-event" className={styles.menuItem}>Assign Athletes to Events</Link>
        <Link to="/tabresultats" className={styles.menuItem}>Ranking</Link>
      </div>
      <br/>
      <div >
            <Link to="/.."><button className={styles.retourHome}>Back</button></Link>
      </div>
    </div>
  );
};

export default HomeOrganizer;
