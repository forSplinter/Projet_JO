import React, { useEffect, useState } from 'react';
import axios from 'axios';
import styles from './Organizer.module.css'; 
import logo1 from './assets/logo1.png'; 
import logo2 from './assets/logo2.png';
import { Link } from 'react-router-dom';

interface Athlete {
  id: number;
  name: string;
  country: string;
  gender: string;
  age: number; 
}

const AthleteManagement: React.FC = () => {
  const [athletes, setAthletes] = useState<Athlete[]>([]);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    const fetchAthletes = async () => {
      try {
        const { data } = await axios.get('/api/athletes');
        setAthletes(data);
      } catch (error) {
        console.error('Error fetching athletes:', error);
      }
      setLoading(false);
    };

    fetchAthletes();
  }, []);

  const handleDelete = async (id: number) => {
    try {
      await axios.delete(`/api/athletes/${id}`);
      setAthletes(athletes.filter(athlete => athlete.id !== id));
    } catch (error) {
      console.error('Failed to delete athlete:', error);
    }
  };

  if (loading) return <p>Loading athletes...</p>;

  return (
    <div className={styles.container}>
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '50px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '50px' }} />
        </header>

      <Link to="/" className={styles.backButton}>Back to home page</Link>
      <h1>Athlete Management</h1>
      <table className={styles.table}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Country</th>
            <th>Gender</th>
            <th>Age</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {athletes.map((athlete) => (
            <tr key={athlete.id}>
              <td>{athlete.id}</td>
              <td>{athlete.name}</td>
              <td>{athlete.country}</td>
              <td>{athlete.gender}</td>
              <td>{athlete.age}</td>
              <td>
                <button onClick={() => handleDelete(athlete.id)}>Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default AthleteManagement;
