import logo1 from'../assets/logo/logo1.png'
import logo2 from'../assets/logo/logo2.png'
import styles from './Visitor.module.css';
import React, { useState,useRef, useEffect } from 'react';
import { Link, Route } from 'react-router-dom';

const Visitor = () => {
  const [searchTerm, setSearchTerm] = useState('');
  const [selectedSport, setSelectedSport] = useState('');
  const buttonRefs = useRef<(HTMLButtonElement | null)[]>([]);

  const sports = ['Athletics', 'Badminton', 'Basketball', 'Boxing', 'Cycling', 'Equestrian', 'Football', 'Golf', 'Gymnastics', 'Handball', 'Judo', 'Tennis', 'Swimming', 'Volleyball'];
  
  
  useEffect(() => {
    if (selectedSport !== '') {
      const index = sports.findIndex(sport => sport.toLowerCase() === selectedSport.toLowerCase());
      if (index !== -1 && buttonRefs.current[index]) {
        buttonRefs.current[index]?.scrollIntoView({ behavior: 'smooth', block: 'center' });
      }
    }
  }, [selectedSport, sports]);

  const handleSearchChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setSearchTerm(event.target.value);
    setSelectedSport('');
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
  
    console.log("Recherche soumise : ", searchTerm);
    const foundSport = sports.find(sport => sport.toLowerCase() === searchTerm.toLowerCase());
    if (foundSport) {
      setSelectedSport(foundSport);
    }
  };

  const handleSportButtonClick = (sport: string) => {
    setSelectedSport(sport);
  };
  
  return (
    <div className={styles.container}> 
      <header>
        <img src={logo2} alt="Logo 2" style={{ height: '70px' ,padding:'10px'}} className ={styles.logo2} />
        <img src={logo1} alt="Logo 1" style={{ height: '100px',padding:'10px' }} className ={styles.logo1} />
      </header>
      <div className={styles.searchBlock}>
        <h2>Sports</h2>
        <form onSubmit={handleSubmit}style={{ display: 'flex'}}>
          <input
            type="text"
            placeholder="Search sport..."
            value={searchTerm}
            onChange={handleSearchChange}
            className={styles.BarreRecherche}
          />
          <button type="submit" className={styles.recherchebouton}>Search</button>
        </form> <br/>
        <div style={{ height: '2px', width: '100%', backgroundColor: 'black',position:'absolute' }}></div>
      </div>


      <div className={styles.Registre}>
        {sports.map((sport, index) => (
          <React.Fragment key={index}>
            {index === 0 || sports[index - 1][0] !== sport[0] ? <h2>{sport[0]}</h2> : null}
            <Link to={`/${sport}`}>
              <button ref={(ref) => buttonRefs.current[index] = ref} style={{ backgroundColor: selectedSport.toLowerCase() === sport.toLowerCase() ? 'black' : 'grey' }} onClick={() => handleSportButtonClick(sport)}>
                {sport}
              </button>
            </Link>
            <br/>
          </React.Fragment>
        ))}
      </div><br/>
      <div className={styles.retourhome}>
            <Link to="../"><button>Back</button></Link>
      </div>
    </div>
    );
}

export default Visitor;
