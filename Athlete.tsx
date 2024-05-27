import React, { useState } from 'react';
import styles from './Athlete.module.css';
import logo1 from './assets/logo1.png'; 
import logo2 from './assets/logo2.png';
import googleLogo from './assets/google.png';
import facebookLogo from './assets/facebook.png';
import appleLogo from './assets/apple.png';

const Athlete: React.FC = () => {
  const [bibNumber, setBibNumber] = useState('');
  const [lastName, setLastName] = useState('');
  const [firstName, setFirstName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [discipline, setDiscipline] = useState('');
  const [isChecked, setIsChecked] = useState(false);

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    console.log(bibNumber, lastName, firstName, email, password, confirmPassword, isChecked);
  };

  return (
    <div className={styles.container}>
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
        <img src={logo2} alt="Logo 2" style={{ height: '50px' }} />
        <img src={logo1} alt="Logo 1" style={{ height: '50px' }} />
        </header>
      <h1>Create Athlete Account</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={bibNumber}
          onChange={e => setBibNumber(e.target.value)}
          placeholder="Bib number"
          className={styles.input}
        />
        <input
          type="text"
          value={lastName}
          onChange={e => setLastName(e.target.value)}
          placeholder="Last Name"
          className={styles.input}
        />
        <input
          type="text"
          value={firstName}
          onChange={e => setFirstName(e.target.value)}
          placeholder="First Name"
          className={styles.input}
        />
        <input
          type="email"
          value={email}
          onChange={e => setEmail(e.target.value)}
          placeholder="Email-Athlete"
          className={styles.input}
        />
        <div className={styles.passwordContainer}>
          <input
            type="password"
            value={password}
            onChange={e => setPassword(e.target.value)}
            placeholder="Password"
            className={styles.input}
          />
          <button type="button" className={styles.helpButton}>?</button>
        </div>
        <input
          type="password"
          value={confirmPassword}
          onChange={e => setConfirmPassword(e.target.value)}
          placeholder="Confirm Password"
          className={styles.input}
        />
         <input
          type="discipline"
          value={discipline}
          onChange={e => setDiscipline(e.target.value)}
          placeholder="Discipline"
          className={styles.input}
        />
        <div className={styles.terms}>
          <input type="checkbox" checked={isChecked} onChange={e => setIsChecked(e.target.checked)} />
          <span>
            You must agree to our <a href="/terms" className={styles.link}>Terms & Conditions</a>
          </span>
        </div>
        <button type="submit" className={styles.submitButton}>Create Account</button>
        <div className={styles.socialButtons}>
         <a href="https://olympics.com/fr/paris-2024" target="_blank" rel="noopener noreferrer" className={styles.socialButton}>
        <img src={googleLogo} alt="Google" />
        </a>
        <a href="https://www.facebook.com/actujeuxolympiques/?locale=fr_FR" target="_blank" rel="noopener noreferrer" className={styles.socialButton}>
        <img src={facebookLogo} alt="Facebook" />
        </a>
        <a href="https://www.apple.com" target="_blank" rel="noopener noreferrer" className={styles.socialButton}>
        <img src={appleLogo} alt="Apple" />
        </a>
        </div>
      </form>
      <p className={styles.centerText}>Existing Users</p>
    </div>
  );
};

export default Athlete;
