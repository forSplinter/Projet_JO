import React from 'react';
import styles from './CSS/tabresultats.module.css';
import logo1 from '../assets/logo/logo1.png';
import logo2 from '../assets/logo/logo2.png';
import { Link } from 'react-router-dom';

const TabResultats: React.FC = () => {
  return (
    <div>
      <header>
        <img src={logo2} alt="Logo 2" className={styles.logo2} />
        <img src={logo1} alt="Logo 1" className={styles.logo1} />
      </header>
      <div className={styles.scoreRegister}>
        <h1>Score Register</h1>
      </div>
      <div className={styles.tabresults}>
        <div className={styles.classementAthlete}>
          <h2>Athlete Ranking</h2>
          <div className={styles.athleteResult}>
            <strong>Name</strong>
            <strong>Sport</strong>
            <strong>Country</strong>
            <strong>Score</strong>
            <strong>Medal</strong>
          </div>
          <button onClick={handleAddAthlete}>Add an athlete</button>
          {/* Ajouter athlète ici */}
        </div>

        <div className={styles.classementPays}>
          <h2>Country Ranking</h2>
          <div className={styles.countryResult}>
            <strong>Country</strong>
            <strong>Medal</strong>
          </div>
          <button onClick={handleAddCountry}>Add a country</button>
          {/* Ajouter pays ici */}
        </div>
      </div>
      <div className={styles.retourorganizer}>
            <Link to="/.."><button>Back</button></Link>
      </div>
    </div>
  );
};

const handleAddAthlete = () => {
  // Code backend 
};

const handleAddCountry = () => {
  // Code backend
};

export default TabResultats;