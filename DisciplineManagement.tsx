import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styles from './Organizer.module.css';
import logo1 from './assets/logo1.png'; 
import logo2 from './assets/logo2.png';
import { Link } from 'react-router-dom';

interface Discipline {
  id: number;
  name: string;
}

const SportDisciplinesPage: React.FC = () => {
  const [disciplines, setDisciplines] = useState<Discipline[]>([]);
  const [newDiscipline, setNewDiscipline] = useState('');

  useEffect(() => {
    const fetchDisciplines = async () => {
      const { data } = await axios.get('/api/disciplines');
      setDisciplines(data);
    };
    fetchDisciplines();
  }, []);

  const handleAdd = async () => {
    const { data } = await axios.post('/api/disciplines', { name: newDiscipline });
    setDisciplines([...disciplines, data]);
    setNewDiscipline('');
  };

  const handleUpdate = async (id: number) => {
    await axios.put(`/api/disciplines/${id}`, { name: newDiscipline });
    const updatedDisciplines = disciplines.map(d => d.id === id ? { ...d, name: newDiscipline } : d);
    setDisciplines(updatedDisciplines);
    setNewDiscipline('');
  };

  return (
    <div className={styles.container}>
       <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '50px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '50px' }} />
        </header>
        <Link to="/" className={styles.backButton}>Back to home page</Link>
      <h1>Sport Disciplines Management</h1>
      <input
        type="text"
        className={styles.input}
        value={newDiscipline}
        onChange={e => setNewDiscipline(e.target.value)}
        placeholder="Add new discipline"
      />
      <button onClick={handleAdd}>Add Discipline</button>
      {disciplines.map((discipline) => (
        <div key={discipline.id}>
          <span>{discipline.name}</span>
          <button onClick={() => handleUpdate(discipline.id)}>Update</button>
        </div>
      ))}
    </div>
  );
};

export default SportDisciplinesPage;
