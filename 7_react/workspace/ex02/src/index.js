import React from 'react';
import ReactDOM from 'react-dom/client';
import MyComponentContainer from './container/MyComponentContainer';
import InfoContainer from './container/infoContainer';

const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<MyComponentContainer name="반하나"></MyComponentContainer>);
root.render(<InfoContainer/>);
