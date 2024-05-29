import React from 'react'
import './App.css'
import { BrowserRouter as Router,Routes, Route } from 'react-router-dom';
import Home from './Accueil/Home';
import Visitor from './Role/Visitor';
import Badminton from './Sports/Badminton';
import Football from './Sports/Football';
import Volleyball from './Sports/Volleyball';
import Organizer from './Role/Organizer';
import AttributionAthleteDiscipline from './OrganizerPart/AttributionAthleteDiscipline';
import AssignAthletesToEventsPage from './OrganizerPart/AssignAthletesToEventsPage';
import AthleteManagement from './OrganizerPart/AthleteManagement';
import DisciplineManagement from './OrganizerPart/DisciplineManagement';
import EventManagementPage from './OrganizerPart/EventManagementPage';
import TabResultats from './OrganizerPart/tabresultats';
import HomeOrganizer from './OrganizerPart/HomePageOrganizer/HomeOrganizer';

const App: React.FC = () => {
  return (
    <Router>
      <div>
        <Routes>
          <Route index element={<Home />} />
          <Route path="/Visitor" element={<Visitor />} />
          <Route path="/Volleyball" element={<Volleyball />} />
          <Route path="/Football" element={<Football />} />
          <Route path="/Badminton" element={<Badminton />} />
          <Route path="/Organizer" element={<Organizer />} />
          <Route path="/tabresultats" element={<TabResultats />} />
          <Route path="/manage-athletes" element={<AthleteManagement />} />
          <Route path="/manage-disciplines" element={<DisciplineManagement />} />
          <Route path="/manage-events" element={<EventManagementPage />} />
          <Route path="/assign-athletes" element={<AttributionAthleteDiscipline />} />
          <Route path="/assign-athletes-event" element={<AssignAthletesToEventsPage />} />
          <Route path="/HomeOrganizer" element={<HomeOrganizer />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;