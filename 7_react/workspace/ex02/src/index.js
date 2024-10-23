import React from 'react';
import ReactDOM from 'react-dom/client';
import MyComponentContainer from '../../ex02/src/container/MyComponentContainer';
import InfoContainer from '../../ex02/src/container/infoContainer';
import Router from '../../ex02/src/Router';

const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(<MyComponentContainer name="반하나"></MyComponentContainer>);
// root.render(<InfoContainer/>);
root.render(<Router/>);