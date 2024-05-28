import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from './HomePage';
import AthleteManagement from './AthleteManagement';
import DisciplineManagement from './DisciplineManagement';
import EventManagementPage from './EventManagementPage';
import AttributionAthleteDiscipline from './AttributionAthleteDiscipline';
import AssignAthletesToEventsPage from './AssignAthletesToEventsPage';

const App: React.FC = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/manage-athletes" element={<AthleteManagement />} />
        <Route path="/manage-disciplines" element={<DisciplineManagement />} />
        <Route path="/manage-events" element={<EventManagementPage />} />
        <Route path="/assign-athletes" element={<AttributionAthleteDiscipline />} />
        <Route path="/assign-athletes-event" element={<AssignAthletesToEventsPage />} />
      </Routes>
    </Router>
  );
};

export default App;





