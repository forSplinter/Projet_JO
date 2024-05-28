import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styles from './Organizer.module.css';
import logo1 from './assets/logo1.png'; 
import logo2 from './assets/logo2.png';
import { Link } from 'react-router-dom';

interface Athlete {
  id: number;
  name: string;
}

interface Discipline {
  id: number;
  name: string;
}

const AssignAthletesPage: React.FC = () => {
  const [athletes, setAthletes] = useState<Athlete[]>([]);
  const [selectedAthlete, setSelectedAthlete] = useState<number>(0);
  const [disciplines, setDisciplines] = useState<Discipline[]>([]);
  const [selectedDiscipline, setSelectedDiscipline] = useState<number>(0);

  useEffect(() => {
    const fetchResources = async () => {
      const athletesData = await axios.get('/api/athletes');
      const disciplinesData = await axios.get('/api/disciplines');
      setAthletes(athletesData.data);
      setDisciplines(disciplinesData.data);
    };
    fetchResources();
  }, []);

  const handleSubmit = async () => {
    await axios.post('/api/assignments', {
      athleteId: selectedAthlete,
      disciplineId: selectedDiscipline
    });
    alert('Athlete assigned to discipline successfully!');
  };

  return (
    <div className={styles.container}>
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '50px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '50px' }} />
        </header>
        <Link to="/" className={styles.backButton}>Back to home page</Link>
      <h1>Assign Athletes to Disciplines</h1>
      <select onChange={e => setSelectedAthlete(parseInt(e.target.value, 10))}>
        <option>Select Athlete</option>
        {athletes.map((athlete) => (
          <option key={athlete.id} value={athlete.id}>{athlete.name}</option>
        ))}
      </select>
      <select onChange={e => setSelectedDiscipline(parseInt(e.target.value, 10))}>
        <option>Select Discipline</option>
        {disciplines.map((discipline) => (
          <option key={discipline.id} value={discipline.id}>{discipline.name}</option>
        ))}
      </select>
      <button onClick={handleSubmit}>Assign</button>
    </div>
  );
};

export default AssignAthletesPage;
