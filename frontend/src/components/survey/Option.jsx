function Option(props) {
  const { data } = props;

  return (
    <div
      style={{
        color: '#FFF',
        border: '1px solid #FFF',
        borderRadius: '10px',
        height: '2.5rem',
        marginLeft: '15%',
        marginRight: '15%',
        marginTop: '15px',
        marginBottom: '15px',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
      }}
    >
      {data}
    </div>
  );
}

export default Option;
