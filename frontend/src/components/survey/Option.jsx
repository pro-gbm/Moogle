/** @jsxImportSource @emotion/react */
import { css } from '@emotion/react';
import { useState } from 'react';

const option = css({
  color: '#FFF',
  borderRadius: '10px',
  height: '2.5rem',
  marginLeft: '15%',
  marginRight: '15%',
  marginTop: '15px',
  marginBottom: '20px',
  display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  cursor: 'pointer',
  transition: 'box-shadow 0.2s ease-out',
  '&:hover': {
    boxShadow: 'inset 0 0 100px 100px rgba(255,255,255,0.1)',
  },
});

function Option(props) {
  const { data, onClickOption } = props;
  const [selectFlag, setSelectFlag] = useState(false);

  return (
    <div
      css={option}
      style={{
        border: selectFlag ? '2px solid #f89d13' : '1px solid #FFF',
        backgroundColor: selectFlag
          ? 'rgba(255, 174, 0, 0.336)'
          : 'rgba(44,21,22, 0.55)',
      }}
      onClick={() => {
        onClickOption(data.id, !selectFlag);
        setSelectFlag(!selectFlag);
      }}
    >
      {data.name ? data.name : data.title}
    </div>
  );
}

export default Option;
