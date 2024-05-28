import React from 'react';
import logo1 from'../assets/logo1.png'//On met .. pour chercher le dossier assets dans le dossier src
import logo2 from'../assets/logo2.png'
import badim from '../assets/image_badminton.png'
import { Link } from 'react-router-dom';
import './Sports.css';
const Badminton = () => {
  return (
    <div className='container'> 
        <header style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px' }}>
            <img src={logo2} alt="Logo 2" style={{ height: '70px',padding:'10px' }} className ='logo2' />
            <img src={logo1} alt="Logo 1" style={{ height: '100px',padding:'10px' }} className ='logo1' />
        </header>
        <div className='titre'>
            <h2>Badminton</h2>
        </div>
        <div className='bad'>
            <img src={badim} alt="badminton" style={{ height: '200px', borderRadius:'8%' }} />
            <p style={{ textAlign: 'justify' }}>Badminton is a racket sport played either in singles or doubles.
                 The objective of the game is to score points by hitting a shuttlecock over the net so that it lands in the opponent's court. 
                 The rules of badminton dictate that the shuttlecock can only be touched once by each player before being returned to the opponent.
                 The shuttlecock must not touch the ground or go out of bounds for a point to be scored. Service also follows strict rules, including 
                 the service zone. 
                 The game is played in sets, with a certain number of points needed to win a set, and certain number of sets to win the match.
                 </p>
        </div>
        <div className='titre2'>
            <h2>Scoreboard</h2>
        </div>
        <div className='scoreboard'>
            <h3 className='premier'>1ère place</h3>
            {/* Contenu pour le premier médaillé */}
            <input type="text" value="" disabled />
            <h3 className='deuxieme'>2ème place</h3>
            {/* Contenu pour le deuxième médaillé */}
            <input type="text" value="" disabled />
            <h3 className='troisieme'>3ème place</h3>
            {/* Contenu pour le troisième médaillé */}
            <input type="text" value="" disabled />
        </div><br/>
        <div className='retourvisitor'>
            <Link to="/Visitor"><button>Retour</button></Link>
        </div>   
    </div>
  );
}

export default Badminton;