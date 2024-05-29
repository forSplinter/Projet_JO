// HomePage.tsx

import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import styles from './Home.module.css';
import logo1 from'../assets/logo/logo1.png'
import logo2 from'../assets/logo/logo2.png'


class Home extends Component {
    render(){
        return <div className={styles.container}>
         
            <header style={{  display: 'flex', justifyContent: 'space-between', alignItems: 'center', padding: '10px'  }}>
                <img src={logo2} alt="Logo 2" style={{ height: '70px',padding:'10px', position: 'absolute', top: '0', left: '0'}} className ={styles.logo2} />
                <img src={logo1} alt="Logo 1" style={{ height: '100px',padding:'10px', position: 'absolute', top: '0', left: '1' }} className ={styles.logo1} />
            </header>
            <div className={styles.block}>
                <h1>Hello !</h1><br/>
                <div className={styles.buttonContainer}>
                    <a href = "/HomeOrganizer"><button>Organizer</button></a>
                </div>
                <div className={styles.buttonContainer}>
                    <a href = "/Visitor"><button>Visitor</button></a>
                </div>

            </div>
        </div>
        
    }
}

export default Home;